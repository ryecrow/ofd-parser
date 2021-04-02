package io.ryecrow.parser

import io.ryecrow.parser.domain.OFDPage
import io.ryecrow.parser.domain.OFDocument
import jakarta.xml.bind.JAXBContext
import jakarta.xml.bind.Unmarshaller
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream
import org.apache.commons.io.IOUtils
import org.ofdspec.*
import java.io.*

/**
 * OFD Parser
 *
 * @author Rene Fang
 * @version 1.0
 */
class OFDParser constructor(private val source: InputStream) {

    constructor(file: File) : this(FileInputStream(file))

    private var ofd: OFD? = null
    private val documents: MutableMap<String, OFDocument> = HashMap()
    private val pages: MutableMap<String, MutableList<OFDPage>> = HashMap()

    @Throws(IOException::class)
    fun parse(): List<OFDocument> {
        val zip = ZipArchiveInputStream(source)
        var entry: ZipArchiveEntry? = zip.nextZipEntry
        var currentEntry: String
        while (entry != null) {
            currentEntry = entry.name
            ByteArrayOutputStream().use { baos ->
                IOUtils.copy(zip, baos)
                ByteArrayInputStream(baos.toByteArray()).use { bais ->
                    when {
                        currentEntry == "OFD.xml" -> parseOFD(bais)
                        currentEntry.endsWith("Document.xml") -> {
                            val document = parseDocument(bais)
                            documents[currentEntry] = OFDocument()
                        }
                        currentEntry.endsWith("Content.xml") -> {
                        }
                        else -> {
                        }
                    }
                }
            }
            entry = zip.nextZipEntry
        }
        return documents.values.toList()
    }

    private fun parseOFD(stream: InputStream) {
        val jaxbContext: JAXBContext = JAXBContext.newInstance(OFD::class.java)
        val jaxbUnmarshaller: Unmarshaller = jaxbContext.createUnmarshaller()
        this.ofd = jaxbUnmarshaller.unmarshal(stream) as OFD

        ofd?.docBody?.forEach { docBody ->
            if ((docBody.docRoot != null) && (docBody.docInfo != null)) {
                documents[docBody.docRoot!!]?.docInfo = docBody.docInfo!!
            }
        }
    }

    private fun parseDocument(stream: InputStream): Document {
        val jaxbContext: JAXBContext = JAXBContext.newInstance(Document::class.java)
        val jaxbUnmarshaller: Unmarshaller = jaxbContext.createUnmarshaller()
        return jaxbUnmarshaller.unmarshal(stream) as Document
    }

    private fun parsePage(stream: InputStream): OFDPage {
        val jaxbContext: JAXBContext = JAXBContext.newInstance(Page::class.java)
        val jaxbUnmarshaller: Unmarshaller = jaxbContext.createUnmarshaller()
        val page = jaxbUnmarshaller.unmarshal(stream) as Page
        val textBuilder = StringBuilder()
        page.content?.layer
            ?.filter { it.textObjectOrPathObjectOrImageObject != null && it.textObjectOrPathObjectOrImageObject!!.isNotEmpty() }
            ?.flatMap { it.textObjectOrPathObjectOrImageObject!! }
            ?.forEach {
                when {
                    (it is CTPageBlock.TextObject) -> {
                        it.cgTransformAndTextCode?.forEach { ttc ->
                            when {
                                (ttc is CTText.TextCode) -> {
                                    textBuilder.append(ttc.value)
                                }
                                (ttc is CTCGTransform) -> {
                                    ttc.glyphs
                                }
                            }
                        }
                    }
                    (it is CTPageBlock.PathObject) -> {

                    }
                    (it is CTPageBlock.ImageObject) -> {

                    }
                }
            }
        return OFDPage(textBuilder.toString(), emptyList(), emptyList(), emptyList(), emptyList())
    }
}