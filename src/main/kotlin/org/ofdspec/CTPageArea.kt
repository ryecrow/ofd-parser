package org.ofdspec

import jakarta.xml.bind.annotation.XmlAccessType
import jakarta.xml.bind.annotation.XmlAccessorType
import jakarta.xml.bind.annotation.XmlElement
import jakarta.xml.bind.annotation.XmlType


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_PageArea", propOrder = ["physicalBox", "applicationBox", "contentBox", "bleedBox"])
class CTPageArea {

    @XmlElement(name = "PhysicalBox", required = true)
    var physicalBox: String? = null

    @XmlElement(name = "ApplicationBox")
    var applicationBox: String? = null

    @XmlElement(name = "ContentBox")
    var contentBox: String? = null

    @XmlElement(name = "BleedBox")
    var bleedBox: String? = null
}