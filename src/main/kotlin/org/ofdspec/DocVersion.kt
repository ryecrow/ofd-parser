package org.ofdspec

import jakarta.xml.bind.annotation.*
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter
import java.util.*
import javax.xml.datatype.XMLGregorianCalendar

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["fileList", "docRoot"])
@XmlRootElement(name = "DocVersion")
class DocVersion {

    @XmlElement(name = "FileList", required = true)
    var fileList: FileList? = null

    @XmlElement(name = "DocRoot", required = true)
    @XmlSchemaType(name = "anyURI")
    var docRoot: String? = null

    @XmlAttribute(name = "ID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter::class)
    @XmlID
    @XmlSchemaType(name = "ID")
    var id: String? = null

    @XmlAttribute(name = "Version")
    var version: String? = null

    @XmlAttribute(name = "Name")
    var name: String? = null

    @XmlAttribute(name = "CreationDate")
    @XmlSchemaType(name = "date")
    var creationDate: XMLGregorianCalendar? = null

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["file"])
    class FileList {
        @XmlElement(name = "File", required = true)
        protected var file: List<File>? = null
            get() {
                if (field == null) {
                    field = ArrayList()
                }
                return field
            }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = ["value"])
        class File {

            @XmlValue
            var value: String? = null

            @XmlAttribute(name = "ID", required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter::class)
            @XmlID
            @XmlSchemaType(name = "ID")
            var id: String? = null
        }
    }
}