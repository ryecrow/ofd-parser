package org.ofdspec

import jakarta.xml.bind.annotation.*
import org.ofdspec.Res.DrawParams.DrawParam

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_DrawParam", propOrder = ["fillColor", "strokeColor"])
@XmlSeeAlso(
    DrawParam::class
)
open class CTDrawParam {

    @XmlElement(name = "FillColor")
    var fillColor: CTColor? = null

    @XmlElement(name = "StrokeColor")
    var strokeColor: CTColor? = null

    @XmlAttribute(name = "Relative")
    var relative: Long? = null

    @XmlAttribute(name = "LineWidth")
    protected var lineWidth: Double? = null
        get() = field ?: 0.353

    @XmlAttribute(name = "Join")
    protected var join: String? = null
        get() = field ?: "Miter"

    @XmlAttribute(name = "Cap")
    protected var cap: String? = null
        get() = field ?: "Butt"

    @XmlAttribute(name = "DashOffset")
    protected var dashOffset: Double? = null
        get() = field ?: 0.0


    @XmlAttribute(name = "DashPattern")
    var dashPattern: String? = null

    @XmlAttribute(name = "MiterLimit")
    protected var miterLimit: Double? = null
        get() = field ?: 4.234
}