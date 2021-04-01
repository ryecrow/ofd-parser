package org.ofdspec

import jakarta.xml.bind.annotation.*
import java.util.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_OutlineElem", propOrder = ["actions", "outlineElem"])
class CTOutlineElem {

    @XmlElement(name = "Actions")
    var actions: Actions? = null

    @XmlElement(name = "OutlineElem")
    var outlineElem: List<CTOutlineElem>? = null
        get() {
            if (field == null) {
                field = ArrayList()
            }
            return field
        }

    @XmlAttribute(name = "Title", required = true)
    var title: String? = null

    @XmlAttribute(name = "Count")
    var count: Int? = null

    @XmlAttribute(name = "Expanded")
    var expanded: Boolean? = null
        get() = field ?: true


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["action"])
    class Actions {
        @XmlElement(name = "Action", required = true)
        var action: List<CTAction>? = null
            get() {
                if (field == null) {
                    field = ArrayList()
                }
                return field
            }
    }
}