package org.ofdspec

import jakarta.xml.bind.annotation.*
import java.util.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_LaGouraudShd", propOrder = ["point", "backColor"])
class CTLaGouraudShd {

    @XmlElement(name = "Point", required = true)
    var point: List<Point>? = null
        get() {
            if (field == null) {
                field = ArrayList()
            }
            return field
        }

    @XmlElement(name = "BackColor")
    var backColor: CTColor? = null

    @XmlAttribute(name = "VerticesPerRow", required = true)
    var verticesPerRow = 0

    @XmlAttribute(name = "Extend")
    var extend: Int? = null


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["color"])
    class Point {

        @XmlElement(name = "Color", required = true)
        var color: CTColor? = null

        @XmlAttribute(name = "X")
        var x: Double? = null

        @XmlAttribute(name = "Y")
        var y: Double? = null
    }
}