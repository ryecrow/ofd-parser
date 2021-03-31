package org.ofdspec

import jakarta.xml.bind.annotation.*
import org.ofdspec.CTPageBlock.TextObject
import java.util.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_Text", propOrder = ["fillColor", "strokeColor", "cgTransformAndTextCode"])
@XmlSeeAlso(
    TextObject::class
)
open class CTText : CTGraphicUnit() {

    @XmlElement(name = "FillColor")
    var fillColor: CTColor? = null

    @XmlElement(name = "StrokeColor")
    var strokeColor: CTColor? = null

    @XmlElements(
        XmlElement(name = "CGTransform", required = true, type = CTCGTransform::class),
        XmlElement(name = "TextCode", required = true, type = TextCode::class)
    )
    protected var cgTransformAndTextCode: List<Any>? = null

    @XmlAttribute(name = "Font", required = true)
    var font: Long = 0

    @XmlAttribute(name = "Size", required = true)
    var size = 0.0

    @XmlAttribute(name = "Stroke")
    protected var stroke: Boolean = false

    @XmlAttribute(name = "Fill")
    protected var fill: Boolean = true

    @XmlAttribute(name = "HScale")
    protected var hScale: Double = 1.0

    @XmlAttribute(name = "ReadDirection")
    protected var readDirection: Int = 0

    @XmlAttribute(name = "CharDirection")
    protected var charDirection: Int = 0

    @XmlAttribute(name = "Weight")
    protected var weight: Int = 400

    @XmlAttribute(name = "Italic")
    protected var italic: Boolean = false


    val cGTransformAndTextCode: List<Any>?
        get() {
            if (cgTransformAndTextCode == null) {
                cgTransformAndTextCode = ArrayList()
            }
            return cgTransformAndTextCode
        }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["value"])
    class TextCode {

        @XmlValue
        var value: String? = null

        @XmlAttribute(name = "X")
        var x: Double? = null

        @XmlAttribute(name = "Y")
        var y: Double? = null

        @XmlAttribute(name = "DeltaX")
        var deltaX: String? = null

        @XmlAttribute(name = "DeltaY")
        var deltaY: String? = null
    }
}