package org.ofdspec

import jakarta.xml.bind.annotation.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_Font", propOrder = ["fontFile"])
@XmlSeeAlso(
    Res.Fonts.Font::class
)
open class CTFont {

    @XmlElement(name = "FontFile")
    @XmlSchemaType(name = "anyURI")
    var fontFile: String? = null

    @XmlAttribute(name = "FontName", required = true)
    var fontName: String? = null


    @XmlAttribute(name = "FamilyName")
    var familyName: String? = null

    @XmlAttribute(name = "Charset")
    var charset: String? = null
        get() = field ?: "unicode"

    @XmlAttribute(name = "Italic")
    var italic: Boolean? = null
        get() = field ?: false

    @XmlAttribute(name = "Bold")
    var bold: Boolean? = null
        get() = field ?: false

    @XmlAttribute(name = "Serif")
    var serif: Boolean? = null
        get() = field ?: false

    @XmlAttribute(name = "FixedWidth")
    var fixedWidth: Boolean? = null
        get() = field ?: false
}