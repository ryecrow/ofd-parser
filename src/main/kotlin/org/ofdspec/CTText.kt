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
    var cgTransformAndTextCode: List<Any>? = null

    @XmlAttribute(name = "Font", required = true)
    var font: Long = 0

    @XmlAttribute(name = "Size", required = true)
    var size = 0.0

    @XmlAttribute(name = "Stroke")
    var stroke: Boolean = false

    @XmlAttribute(name = "Fill")
    var fill: Boolean = true

    @XmlAttribute(name = "HScale")
    var hScale: Double = 1.0

    @XmlAttribute(name = "ReadDirection")
    var readDirection: Int = 0

    @XmlAttribute(name = "CharDirection")
    var charDirection: Int = 0

    @XmlAttribute(name = "Weight")
    var weight: Int = 400

    @XmlAttribute(name = "Italic")
    var italic: Boolean = false


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