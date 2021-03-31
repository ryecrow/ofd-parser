package org.ofdspec

import jakarta.xml.bind.annotation.*
import org.ofdspec.CTPageBlock.ImageObject

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_Image", propOrder = ["border"])
@XmlSeeAlso(
    ImageObject::class
)
open class CTImage : CTGraphicUnit() {

    @XmlElement(name = "Border")
    var border: Border? = null

    @XmlAttribute(name = "ResourceID", required = true)
    var resourceID: Long = 0

    @XmlAttribute(name = "Substitution")
    var substitution: Long? = null

    @XmlAttribute(name = "ImageMask")
    var imageMask: Long? = null

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["borderColor"])
    class Border {

        @XmlElement(name = "BorderColor")
        var borderColor: CTColor? = null

        @XmlAttribute(name = "LineWidth")
        protected var lineWidth: Double = 0.353

        @XmlAttribute(name = "HorizonalCornerRadius")
        protected var horizonalCornerRadius: Double = 0.0

        @XmlAttribute(name = "VerticalCornerRadius")
        protected var verticalCornerRadius: Double = 0.0

        @XmlAttribute(name = "DashOffset")
        protected var dashOffset: Double = 0.0


        @XmlAttribute(name = "DashPattern")
        var dashPattern: String? = null
    }
}