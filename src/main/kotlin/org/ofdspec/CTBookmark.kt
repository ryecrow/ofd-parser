package org.ofdspec

import jakarta.xml.bind.annotation.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_Bookmark", propOrder = ["dest"])
class CTBookmark {

    @XmlElement(name = "Dest", required = true)
    var dest: CTDest? = null

    @XmlAttribute(name = "Name", required = true)
    var name: String? = null
}