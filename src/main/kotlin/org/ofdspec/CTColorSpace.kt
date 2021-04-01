package org.ofdspec

import jakarta.xml.bind.annotation.*
import java.util.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_ColorSpace", propOrder = ["palette"])
@XmlSeeAlso(Res.ColorSpaces.ColorSpace::class)
open class CTColorSpace {

    @XmlElement(name = "Palette")
    var palette: Palette? = null

    @XmlAttribute(name = "Type", required = true)
    var type: String? = null

    @XmlAttribute(name = "BitsPerComponent")
    var bitsPerComponent: Int? = null
        get() = field ?: 8

    @XmlAttribute(name = "Profile")
    var profile: String? = null

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["cv"])
    class Palette {
        @XmlElement(name = "CV", required = true)
        var cv: List<String>? = null

        val cV: List<String>?
            get() {
                if (cv == null) {
                    cv = ArrayList()
                }
                return cv
            }
    }
}