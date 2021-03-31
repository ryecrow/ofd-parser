package org.ofdspec

import jakarta.xml.bind.annotation.*
import org.ofdspec.Page.Content.Layer


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_Layer")
@XmlSeeAlso(Layer::class)
open class CTLayer : CTPageBlock() {
    @XmlAttribute(name = "Type")
    protected var type: String? = null
        get() = field ?: "Body"


    @XmlAttribute(name = "DrawParam")
    var drawParam: Long? = null
}