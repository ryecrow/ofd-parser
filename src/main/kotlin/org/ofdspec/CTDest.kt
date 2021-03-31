package org.ofdspec

import jakarta.xml.bind.annotation.XmlAccessType
import jakarta.xml.bind.annotation.XmlAccessorType
import jakarta.xml.bind.annotation.XmlAttribute
import jakarta.xml.bind.annotation.XmlType

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_Dest")
class CTDest {

    @XmlAttribute(name = "Type", required = true)
    var type: String? = null

    @XmlAttribute(name = "PageID", required = true)
    var pageID: Long = 0

    @XmlAttribute(name = "Left")
    var left: Double? = null

    @XmlAttribute(name = "Top")
    var top: Double? = null

    @XmlAttribute(name = "Right")
    var right: Double? = null

    @XmlAttribute(name = "Bottom")
    var bottom: Double? = null

    @XmlAttribute(name = "Zoom")
    var zoom: Double? = null
}