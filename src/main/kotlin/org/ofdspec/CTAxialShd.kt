package org.ofdspec

import jakarta.xml.bind.annotation.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_AxialShd", propOrder = ["segment"])
class CTAxialShd {

    @XmlElement(name = "Segment", required = true)
    var segment: List<Segment>? = null
        get() {
            if (field == null) {
                field = ArrayList()
            }
            return field
        }

    @XmlAttribute(name = "MapType")
    var mapType: String? = null
        get() = field ?: "Direct"

    @XmlAttribute(name = "MapUnit")
    var mapUnit: Double? = null

    @XmlAttribute(name = "Extend")
    var extend: Int? = null
        get() = field ?: 0

    @XmlAttribute(name = "StartPoint", required = true)
    var startPoint: String? = null

    @XmlAttribute(name = "EndPoint", required = true)
    var endPoint: String? = null

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["color"])
    class Segment {

        @XmlElement(name = "Color", required = true)
        var color: CTColor? = null

        @XmlAttribute(name = "Position")
        var position: Double? = null
    }
}