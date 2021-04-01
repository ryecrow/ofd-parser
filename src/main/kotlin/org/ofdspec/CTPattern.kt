package org.ofdspec

import jakarta.xml.bind.annotation.*


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_Pattern", propOrder = ["cellContent"])
class CTPattern {

    @XmlElement(name = "CellContent", required = true)
    var cellContent: CellContent? = null

    @XmlAttribute(name = "Width", required = true)
    var width = 0.0

    @XmlAttribute(name = "Height", required = true)
    var height = 0.0

    @XmlAttribute(name = "XStep")
    var xStep: Double? = null

    @XmlAttribute(name = "YStep")
    var yStep: Double? = null

    @XmlAttribute(name = "ReflectMethod")
    var reflectMethod: String? = null
        get() = field ?: "Normal"

    @XmlAttribute(name = "RelativeTo")
    var relativeTo: String? = null
        get() = field ?: "Object"

    @XmlAttribute(name = "CTM")
    var cTM: String? = null

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    class CellContent : CTPageBlock() {

        @XmlAttribute(name = "Thumbnail")
        var thumbnail: Long? = null
    }
}