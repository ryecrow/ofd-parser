package org.ofdspec

import jakarta.xml.bind.annotation.*
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter
import java.util.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["maxSignId", "signature"])
@XmlRootElement(name = "Signatures")
class Signatures {

    @XmlElement(name = "MaxSignId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter::class)
    @XmlID
    @XmlSchemaType(name = "ID")
    var maxSignId: String? = null

    @XmlElement(name = "Signature")
    var signature: List<Signature>? = null
        get() {
            if (field == null) {
                field = ArrayList()
            }
            return field
        }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    class Signature {

        @XmlAttribute(name = "ID", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter::class)
        @XmlID
        @XmlSchemaType(name = "ID")
        var id: String? = null

        @XmlAttribute(name = "Type")
        var type: String? = null
            get() = field ?: "Seal"

        @XmlAttribute(name = "BaseLoc", required = true)
        var baseLoc: String? = null
    }
}