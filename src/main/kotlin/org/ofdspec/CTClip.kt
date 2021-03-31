package org.ofdspec

import jakarta.xml.bind.annotation.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_Clip", propOrder = ["area"])
class CTClip {

    @XmlElement(name = "Area", required = true)
    protected var area: List<Area>? = null
        get() {
            if (field == null) {
                field = ArrayList()
            }
            return field
        }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["path", "text"])
    class Area {

        @XmlElement(name = "Path")
        var path: CTPath? = null

        @XmlElement(name = "Text")
        var text: CTText? = null

        @XmlAttribute(name = "DrawParam")
        var drawParam: Long? = null

        @XmlAttribute(name = "CTM")
        var cTM: String? = null
    }
}