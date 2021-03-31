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
    protected var charset: String? = null
        get() = field ?: "unicode"

    @XmlAttribute(name = "Italic")
    protected var italic: Boolean? = null
        get() = field ?: false

    @XmlAttribute(name = "Bold")
    protected var bold: Boolean? = null
        get() = field ?: false

    @XmlAttribute(name = "Serif")
    protected var serif: Boolean? = null
        get() = field ?: false

    @XmlAttribute(name = "FixedWidth")
    protected var fixedWidth: Boolean? = null
        get() = field ?: false
}