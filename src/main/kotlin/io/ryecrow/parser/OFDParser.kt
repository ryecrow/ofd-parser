package io.ryecrow.parser

import io.ryecrow.parser.domain.OFDocument
import io.ryecrow.parser.exception.OFDException
import jakarta.xml.bind.JAXBContext
import jakarta.xml.bind.Unmarshaller
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream
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

    @Throws(IOException::class)
    fun parse(): OFDocument {
        val zip = ZipArchiveInputStream(source)
        var entry: ZipArchiveEntry? = zip.nextZipEntry
        var ofDocument: OFDocument? = null
        var parseException: Exception? = null
        while (entry != null) {
            when {
                entry.name.equals("OFD.xml") -> {
                    ofDocument = try {
                        OFDocument(parseOFD(zip))
                    } catch (e: Exception) {
                        parseException = e
                        null
                    }
                }
            }
            entry = zip.nextZipEntry
        }
        return ofDocument ?: throw OFDException("Failed to parse ")
    }

    private fun parseOFD(stream: InputStream): OFD {
        val jaxbContext: JAXBContext = JAXBContext.newInstance(OFD::class.java)
        val jaxbUnmarshaller: Unmarshaller = jaxbContext.createUnmarshaller()
        return jaxbUnmarshaller.unmarshal(stream) as OFD
    }
}