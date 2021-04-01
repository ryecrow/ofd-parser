package io.ryecrow.parser

import io.ryecrow.parser.domain.OFDocument
import io.ryecrow.parser.util.JAXBContexts
import jakarta.xml.bind.JAXBContext
import jakarta.xml.bind.Unmarshaller
import mu.KotlinLogging
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream
import org.ofdspec.Document
import org.ofdspec.OFD
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStream

/**
 * OFD Parser
 *
 * @author Rene Fang
 * @version 1.0
 */
class OFDParser constructor(private val source: InputStream) {

    constructor(file: File) : this(FileInputStream(file))

    private val log = KotlinLogging.logger { }

    private var ofd: OFD? = null
    private val documents: MutableMap<String, OFDocument> = HashMap()

    @Throws(IOException::class)
    fun parse(): List<OFDocument> {
        val zip = ZipArchiveInputStream(source)
        var entry: ZipArchiveEntry? = zip.nextZipEntry
        while (entry != null) {
            when {
                entry.name.equals("OFD.xml") -> parseOFD(zip)
                entry.name.endsWith("Document.xml") -> {
                    val document: OFDocument? = documents[entry.name]
                    if (document != null) {

                    }
                }
            }
            entry = zip.nextZipEntry
        }
        return documents.values.toList()
    }

    private fun parseOFD(stream: InputStream) {
            val jaxbContext: JAXBContext = JAXBContexts[OFD::class]
            val jaxbUnmarshaller: Unmarshaller = jaxbContext.createUnmarshaller()
        this.ofd = jaxbUnmarshaller.unmarshal(stream) as OFD

        ofd?.docBody?.forEach { docBody ->
            if ((docBody.docRoot != null) && (docBody.docInfo != null)) {
                documents[docBody.docRoot!!] = OFDocument(docBody.docInfo!!)
            }
        }
    }

    private fun parseDocument(stream: InputStream): Document {
        val jaxbContext: JAXBContext = JAXBContexts[Document::class]
        val jaxbUnmarshaller: Unmarshaller = jaxbContext.createUnmarshaller()
        return jaxbUnmarshaller.unmarshal(stream) as Document
    }
}