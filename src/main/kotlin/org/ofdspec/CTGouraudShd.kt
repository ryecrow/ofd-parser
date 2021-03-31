package org.ofdspec

import jakarta.xml.bind.annotation.*
import java.util.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_GouraudShd", propOrder = ["point", "backColor"])
class CTGouraudShd {
    @XmlElement(name = "Point", required = true)
    protected var point: List<Point>? = null
        get() {
            if (field == null) {
                field = ArrayList()
            }
            return field
        }

    @XmlElement(name = "BackColor")
    var backColor: CTColor? = null

    @XmlAttribute(name = "Extend")
    var extend: Int? = null


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["color"])
    class Point {

        @XmlElement(name = "Color", required = true)
        var color: CTColor? = null

        @XmlAttribute(name = "X", required = true)
        var x = 0.0

        @XmlAttribute(name = "Y", required = true)
        var y = 0.0

        @XmlAttribute(name = "EdgeFlag")
        var edgeFlag: Int? = null
    }
}