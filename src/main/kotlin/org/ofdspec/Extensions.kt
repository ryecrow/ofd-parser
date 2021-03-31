package org.ofdspec

import jakarta.xml.bind.annotation.*
import java.util.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["extension"])
@XmlRootElement(name = "Extensions")
class Extensions {
    @XmlElement(name = "Extension", required = true)
    protected var extension: List<CTExtension>? = null
        get() {
            if (field == null) {
                field = ArrayList()
            }
            return field
        }
}