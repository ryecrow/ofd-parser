package io.ryecrow.parser

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream
import org.apache.commons.compress.archivers.zip.ZipFile
import org.apache.commons.io.IOUtils
import org.apache.tika.config.Field
import org.apache.tika.exception.TikaException
import org.apache.tika.extractor.EmbeddedDocumentExtractor
import org.apache.tika.extractor.EmbeddedDocumentUtil
import org.apache.tika.io.CloseShieldInputStream
import org.apache.tika.io.TemporaryResources
import org.apache.tika.io.TikaInputStream
import org.apache.tika.metadata.Metadata
import org.apache.tika.mime.MediaType
import org.apache.tika.parser.AbstractParser
import org.apache.tika.parser.ParseContext
import org.apache.tika.parser.Parser
import org.apache.tika.parser.utils.ZipSalvager
import org.apache.tika.sax.BodyContentHandler
import org.apache.tika.sax.EmbeddedContentHandler
import org.apache.tika.sax.OfflineContentHandler
import org.apache.tika.sax.XHTMLContentHandler
import org.apache.tika.utils.ParserUtils
import org.apache.tika.utils.XMLReaderUtils
import org.xml.sax.Attributes
import org.xml.sax.ContentHandler
import org.xml.sax.SAXException
import org.xml.sax.helpers.DefaultHandler
import java.io.IOException
import java.io.InputStream
import java.io.UnsupportedEncodingException
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
import java.nio.file.Path
import java.util.*
import java.util.zip.ZipException
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/**
 * OFD Parser
 * TODO: Most of codes in this class are copied from Tika's EpubParser, need to be rewritten
 *
 * @author Rene Fang
 * @version 1.0
 */
class OFDParser : AbstractParser() {

    companion object {
        private val SUPPORT_TYPES = setOf(MediaType.application("ofd"))
    }

    override fun getSupportedTypes(context: ParseContext?): Set<MediaType> {
        return SUPPORT_TYPES
    }

    private var meta: Parser = OFDMetaParser()

    private val metaParser: Parser
        get() = meta

    private var content: Parser = OFDContentParser()

    @Field
    var streaming = false

    @Throws(IOException::class, SAXException::class, TikaException::class)
    override fun parse(
        stream: InputStream, handler: ContentHandler?,
        metadata: Metadata, context: ParseContext
    ) {
        // Because an EPub file is often made up of multiple XHTML files,
        //  we need explicit control over the start and end of the document
        val xhtml = XHTMLContentHandler(handler, metadata)
        xhtml.startDocument()
        var caughtException: IOException? = null
        val childHandler: ContentHandler = EmbeddedContentHandler(
            BodyContentHandler(xhtml)
        )
        if (streaming) {
            try {
                streamingParse(stream, childHandler, metadata, context)
            } catch (e: IOException) {
                caughtException = e
            }
        } else {
            try {
                bufferedParse(stream, childHandler, xhtml, metadata, context)
            } catch (e: IOException) {
                caughtException = e
            }
        }
        // Finish everything
        xhtml.endDocument()
        if (caughtException != null) {
            throw caughtException
        }
    }

    @Throws(IOException::class, TikaException::class, SAXException::class)
    private fun streamingParse(
        stream: InputStream, bodyHandler: ContentHandler,
        metadata: Metadata, context: ParseContext
    ) {
        val zip = ZipArchiveInputStream(stream)
        var entry: ZipArchiveEntry? = zip.nextZipEntry
        while (entry != null) {
            when {
                entry.name.equals("OFD.xml") -> meta.parse(zip, DefaultHandler(), metadata, context)
                entry.name.endsWith(".xml") -> content.parse(zip, bodyHandler, metadata, context)
            }
            entry = zip.nextZipEntry
        }
    }

    @Throws(IOException::class)
    private fun updateMimeType(`is`: InputStream, metadata: Metadata) {
        var type: String? = IOUtils.toString(`is`, StandardCharsets.UTF_8)
        //often has trailing new lines
        if (type != null) {
            type = type.trim { it <= ' ' }
        }
        metadata[Metadata.CONTENT_TYPE] = type
    }

    @Throws(IOException::class, TikaException::class, SAXException::class)
    private fun bufferedParse(
        stream: InputStream,
        bodyHandler: ContentHandler, xhtml: XHTMLContentHandler,
        metadata: Metadata, context: ParseContext
    ) {
        val tis: TikaInputStream
        var temporaryResources: TemporaryResources? = null
        if (TikaInputStream.isTikaInputStream(stream)) {
            tis = TikaInputStream.cast(stream)
            if (tis.openContainer is ZipFile) {
                bufferedParseZipFile(
                    tis.openContainer as ZipFile,
                    bodyHandler, xhtml, metadata, context, true
                )
                return
            }
        } else {
            temporaryResources = TemporaryResources()
            tis = TikaInputStream.get(CloseShieldInputStream(stream), temporaryResources)
        }
        var zipFile: ZipFile
        try {
            zipFile = ZipFile(tis.path.toFile())
        } catch (e: ZipException) {
            ParserUtils.recordParserFailure(this, e, metadata)
            trySalvage(tis.path, bodyHandler, xhtml, metadata, context)
            return
        } finally {
            //if we had to wrap tis
            if (temporaryResources != null) {
                tis.close()
            }
        }
        try {
            bufferedParseZipFile(zipFile, bodyHandler, xhtml, metadata, context, true)
        } finally {
            zipFile.close()
        }
    }

    @Throws(IOException::class, TikaException::class, SAXException::class)
    private fun trySalvage(
        brokenZip: Path, bodyHandler: ContentHandler,
        xhtml: XHTMLContentHandler,
        metadata: Metadata, context: ParseContext
    ) {
        val resources = TemporaryResources()
        resources.use {
            val salvaged = it.createTempFile()
            ZipSalvager.salvageCopy(brokenZip.toFile(), salvaged.toFile())
            var success: Boolean
            ZipFile(salvaged.toFile()).use { zipFile ->
                success = bufferedParseZipFile(zipFile, bodyHandler, xhtml, metadata, context, false)
            }
            if (!success) {
                TikaInputStream.get(salvaged).use { `is` -> streamingParse(`is`, xhtml, metadata, context) }
            }
        }
    }

    @Throws(IOException::class, TikaException::class, SAXException::class)
    private fun bufferedParseZipFile(
        zipFile: ZipFile,
        bodyHandler: ContentHandler, xhtml: XHTMLContentHandler,
        metadata: Metadata, context: ParseContext,
        isStrict: Boolean
    ): Boolean {
        val rootOPF = getRoot(zipFile, context) ?: return false
        var zae = zipFile.getEntry(rootOPF)
        if (zae == null || !zipFile.canReadEntryData(zae)) {
            return false
        }
        metaParser.parse(zipFile.getInputStream(zae), DefaultHandler(), metadata, context)
        val contentOrderScraper = ContentOrderScraper()
        zipFile.getInputStream(zae).use { `is` ->
            XMLReaderUtils.parseSAX(
                `is`,
                OfflineContentHandler(contentOrderScraper), context
            )
        }
        //if no content items, false
        if (contentOrderScraper.contentItems.size == 0) {
            return false
        }
        var relativePath = ""
        if (rootOPF.lastIndexOf("/") > -1) {
            relativePath = rootOPF.substring(0, rootOPF.lastIndexOf("/") + 1)
        }
        if (isStrict) {
            var found = 0
            for (id in contentOrderScraper.contentItems) {
                val hRefMediaPair = contentOrderScraper.locationMap[id]
                if (hRefMediaPair?.href != null) {
                    zae = zipFile.getEntry(relativePath + hRefMediaPair.href)
                    if (zae != null && zipFile.canReadEntryData(zae)) {
                        found++
                    }
                }
            }
            //if not perfect match btwn items and readable items
            //return false
            if (found != contentOrderScraper.contentItems.size) {
                return false
            }
        }
        extractMetadata(zipFile, metadata, context)
        val processed: MutableSet<String> = HashSet()
        for (id in contentOrderScraper.contentItems) {
            val hRefMediaPair = contentOrderScraper.locationMap[id]
            if (hRefMediaPair != null && hRefMediaPair.href != null) {
                //we need to test for xhtml/xml because the content parser
                //expects that.
                var shouldParse = false
                val href = hRefMediaPair.href.toLowerCase(Locale.US)
                if (hRefMediaPair.media != null) {
                    val mediaType = hRefMediaPair.media.toLowerCase(Locale.US)
                    if (mediaType.contains("html")) {
                        shouldParse = true
                    }
                } else if (href.endsWith("htm") || href.endsWith("html") || href.endsWith(".xml")) {
                    shouldParse = true
                }
                if (shouldParse) {
                    zae = zipFile.getEntry(relativePath + hRefMediaPair.href)
                    if (zae != null) {
                        zipFile.getInputStream(zae).use { `is` ->
                            content.parse(`is`, bodyHandler, metadata, context)
                            processed.add(id)
                        }
                    }
                }
            }
        }

        //now handle embedded files
        val embeddedDocumentExtractor = EmbeddedDocumentUtil.getEmbeddedDocumentExtractor(context)
        for (id in contentOrderScraper.locationMap.keys) {
            if (!processed.contains(id)) {
                val hRefMediaPair = contentOrderScraper.locationMap[id]
                if (shouldHandleEmbedded(hRefMediaPair!!.media)) {
                    handleEmbedded(
                        zipFile, relativePath,
                        hRefMediaPair, embeddedDocumentExtractor, xhtml, metadata
                    )
                }
            }
        }
        return true
    }

    private fun shouldHandleEmbedded(media: String?): Boolean {
        if (media == null) {
            return true
        }
        val lc = media.toLowerCase(Locale.US)
        return when {
            lc.contains("css") -> false
            lc.contains("svg") -> false
            lc.endsWith("/xml") -> false
            lc.contains("x-ibooks") -> false
            (lc == "application/x-dtbncx+xml") -> false
            else -> true
        }
    }

    @Throws(IOException::class, SAXException::class)
    private fun handleEmbedded(
        zipFile: ZipFile, relativePath: String,
        hRefMediaPair: HRefMediaPair?,
        embeddedDocumentExtractor: EmbeddedDocumentExtractor,
        xhtml: XHTMLContentHandler, parentMetadata: Metadata
    ) {
        if (hRefMediaPair!!.href == null) {
            return
        }
        val fullPath = relativePath + hRefMediaPair.href
        val ze: ZipArchiveEntry = zipFile.getEntry(fullPath)
        if (ze == null || !zipFile.canReadEntryData(ze)) {
            return
        }
        val embeddedMetadata = Metadata()
        if (hRefMediaPair.media != null && !hRefMediaPair.media.isBlank()) {
            embeddedMetadata[Metadata.CONTENT_TYPE] = hRefMediaPair.media
        }
        if (!embeddedDocumentExtractor.shouldParseEmbedded(embeddedMetadata)) {
            return
        }

        try {
            TikaInputStream.get(zipFile.getInputStream(ze)).use {
                xhtml.startElement("div", "class", "embedded")
                embeddedDocumentExtractor.parseEmbedded(
                    it,
                    EmbeddedContentHandler(xhtml),
                    embeddedMetadata, false
                )
            }
        } catch (e: IOException) {
            //store this exception in the parent's metadata
            EmbeddedDocumentUtil.recordEmbeddedStreamException(e, parentMetadata)
            return
        }
        xhtml.endElement("div")
    }

    @Throws(IOException::class, TikaException::class, SAXException::class)
    private fun extractMetadata(zipFile: ZipFile, metadata: Metadata, context: ParseContext) {
        var zae: ZipArchiveEntry = zipFile.getEntry("mimetype")
        if (zae != null && zipFile.canReadEntryData(zae)) {
            zipFile.getInputStream(zae).use { `is` -> updateMimeType(`is`, metadata) }
        }
        zae = zipFile.getEntry("metadata.xml")
        if (zae != null && zipFile.canReadEntryData(zae)) {
            zipFile.getInputStream(zae).use { `is` ->
                metaParser.parse(
                    `is`,
                    DefaultHandler(),
                    metadata,
                    context
                )
            }
        }
    }

    @Throws(IOException::class, TikaException::class, SAXException::class)
    private fun getRoot(zipFile: ZipFile, context: ParseContext): String? {
        val container: ZipArchiveEntry = zipFile.getEntry("META-INF/container.xml")
        return if (container != null) {
            val rootFinder = RootFinder()
            zipFile.getInputStream(container).use { `is` ->
                XMLReaderUtils.parseSAX(
                    `is`,
                    OfflineContentHandler(rootFinder),
                    context
                )
            }
            rootFinder.root
        } else {
            val entryEnum: Enumeration<ZipArchiveEntry> = zipFile.getEntries()
            while (entryEnum.hasMoreElements()) {
                val ze: ZipArchiveEntry = entryEnum.nextElement()
                if (ze.getName().toLowerCase(Locale.US).endsWith(".opf") &&
                    zipFile.canReadEntryData(ze)
                ) {
                    return ze.getName()
                }
            }
            null
        }
    }

    private class RootFinder : DefaultHandler() {
        var root: String? = null

        @Throws(SAXException::class)
        override fun startElement(
            uri: String, localName: String, name: String, atts: Attributes
        ) {
            if ("rootfile".equals(localName, ignoreCase = true)) {
                root = XMLReaderUtils.getAttrValue("full-path", atts)
            }
        }
    }

    private class ContentOrderScraper : DefaultHandler() {
        var locationMap: MutableMap<String, HRefMediaPair> = HashMap()
        var contentItems: MutableList<String> = ArrayList()
        var inManifest = false
        var inSpine = false

        @Throws(SAXException::class)
        override fun startElement(
            uri: String, localName: String, name: String, atts: Attributes
        ) {
            if ("manifest".equals(localName, ignoreCase = true)) {
                inManifest = true
            } else if ("spine".equals(localName, ignoreCase = true)) {
                inSpine = true
            }
            if (inManifest) {
                if ("item".equals(localName, ignoreCase = true)) {
                    val id = XMLReaderUtils.getAttrValue("id", atts)
                    var href = XMLReaderUtils.getAttrValue("href", atts)
                    val mime = XMLReaderUtils.getAttrValue("media-type", atts)
                    if (id != null && href != null) {
                        try {
                            href = URLDecoder.decode(href, StandardCharsets.UTF_8.name())
                        } catch (e: UnsupportedEncodingException) {
                        }
                        locationMap[id] = HRefMediaPair(href, mime)
                    }
                }
            }
            if (inSpine) {
                if ("itemRef".equals(localName, ignoreCase = true)) {
                    val id = XMLReaderUtils.getAttrValue("idref", atts)
                    if (id != null) {
                        contentItems.add(id)
                    }
                }
            }
        }

        @Throws(SAXException::class)
        override fun endElement(
            uri: String, localName: String, name: String
        ) {
            if ("manifest".equals(localName, ignoreCase = true)) {
                inManifest = false
            } else if ("spine".equals(localName, ignoreCase = true)) {
                inSpine = false
            }
        }
    }

    private class HRefMediaPair(val href: String?, val media: String?) {
        override fun toString(): String {
            return "HRefMediaPair{" +
                    "href='" + href + '\'' +
                    ", media='" + media + '\'' +
                    '}'
        }
    }
}