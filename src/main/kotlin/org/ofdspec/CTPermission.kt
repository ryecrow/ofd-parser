package org.ofdspec

import jakarta.xml.bind.annotation.*
import javax.xml.datatype.XMLGregorianCalendar


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "CT_Permission",
    propOrder = ["edit", "annot", "export", "signature", "watermark", "printScreen", "print", "validPeriod"]
)
class CTPermission {

    @XmlElement(name = "Edit", defaultValue = "true")
    var edit: Boolean? = null

    @XmlElement(name = "Annot", defaultValue = "true")
    var annot: Boolean? = null

    @XmlElement(name = "Export", defaultValue = "true")
    var export: Boolean? = null

    @XmlElement(name = "Signature", defaultValue = "true")
    var signature: Boolean? = null

    @XmlElement(name = "Watermark", defaultValue = "true")
    var watermark: Boolean? = null

    @XmlElement(name = "PrintScreen", defaultValue = "true")
    var printScreen: Boolean? = null

    @XmlElement(name = "Print")
    var print: Print? = null

    @XmlElement(name = "ValidPeriod")
    var validPeriod: ValidPeriod? = null

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    class Print {

        @XmlAttribute(name = "Printable", required = true)
        var printable = false

        @XmlAttribute(name = "Copies")
        var copies: Int = -1
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    class ValidPeriod {

        @XmlAttribute(name = "StartDate")
        @XmlSchemaType(name = "dateTime")
        var startDate: XMLGregorianCalendar? = null

        @XmlAttribute(name = "EndDate")
        @XmlSchemaType(name = "dateTime")
        var endDate: XMLGregorianCalendar? = null
    }
}