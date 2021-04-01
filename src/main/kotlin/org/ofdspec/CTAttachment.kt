package org.ofdspec

import jakarta.xml.bind.annotation.*
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter
import javax.xml.datatype.XMLGregorianCalendar

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_Attachment", propOrder = ["fileLoc"])
class CTAttachment {

    @XmlElement(name = "FileLoc", required = true)
    @XmlSchemaType(name = "anyURI")
    var fileLoc: String? = null

    @XmlAttribute(name = "ID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter::class)
    @XmlID
    @XmlSchemaType(name = "ID")
    var id: String? = null

    @XmlAttribute(name = "Name", required = true)
    var name: String? = null

    @XmlAttribute(name = "Format")
    var format: String? = null

    @XmlAttribute(name = "CreationDate")
    @XmlSchemaType(name = "dateTime")
    var creationDate: XMLGregorianCalendar? = null

    @XmlAttribute(name = "ModDate")
    @XmlSchemaType(name = "dateTime")
    var modDate: XMLGregorianCalendar? = null

    @XmlAttribute(name = "Size")
    var size: Double? = null

    @XmlAttribute(name = "Visible")
    var visible: Boolean? = null
        get() = field ?: true

    @XmlAttribute(name = "Usage")
    var usage: String? = null
        get() = field ?: "none"
}