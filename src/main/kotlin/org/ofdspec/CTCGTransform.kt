package org.ofdspec

import jakarta.xml.bind.annotation.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_CGTransform", propOrder = ["glyphs"])
class CTCGTransform {

    @XmlElement(name = "Glyphs")
    var glyphs: String? = null

    @XmlAttribute(name = "CodePosition", required = true)
    var codePosition = 0

    @XmlAttribute(name = "CodeCount")
    protected var codeCount: Int? = null
        get() = field ?: 1

    @XmlAttribute(name = "GlyphCount")
    protected var glyphCount: Int? = null
        get() = field ?: 1
}