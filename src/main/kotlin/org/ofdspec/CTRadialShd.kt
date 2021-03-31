package org.ofdspec

import jakarta.xml.bind.annotation.*
import java.util.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_RadialShd", propOrder = ["segment"])
class CTRadialShd {

    @XmlElement(name = "Segment", required = true)
    protected var segment: List<Segment>? = null
        get() {
            if (field == null) {
                field = ArrayList()
            }
            return field
        }

    @XmlAttribute(name = "MapType")
    protected var mapType: String? = null
        get() = field ?: "Direct"

    @XmlAttribute(name = "MapUnit")
    var mapUnit: Double? = null

    @XmlAttribute(name = "Eccentricity")
    protected var eccentricity: Double = 0.0

    @XmlAttribute(name = "Angle")
    protected var angle: Double = 0.0

    @XmlAttribute(name = "StartPoint", required = true)
    var startPoint: String? = null

    @XmlAttribute(name = "StartRadius")
    protected var startRadius: Double = 0.0

    @XmlAttribute(name = "EndPoint", required = true)
    var endPoint: String? = null

    @XmlAttribute(name = "EndRadius", required = true)
    var endRadius = 0.0

    @XmlAttribute(name = "Extend")
    protected var extend: Int? = 0

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["color"])
    class Segment {

        @XmlElement(name = "Color", required = true)
        var color: CTColor? = null

        @XmlAttribute(name = "Position")
        var position: Double? = null
    }
}