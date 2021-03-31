package org.ofdspec

import jakarta.xml.bind.annotation.*
import java.util.*


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_GraphicUnit", propOrder = ["actions", "clips"])
@XmlSeeAlso(
    CTText::class, CTPath::class, CTImage::class, CTComposite::class
)
abstract class CTGraphicUnit {

    @XmlElement(name = "Actions")
    var actions: Actions? = null

    @XmlElement(name = "Clips")
    var clips: Clips? = null

    @XmlAttribute(name = "Boundary", required = true)
    var boundary: String? = null

    @XmlAttribute(name = "Name")
    var name: String? = null

    @XmlAttribute(name = "Visible")
    protected var visible: Boolean? = null
        get() = field ?: true


    @XmlAttribute(name = "CTM")
    var cTM: String? = null


    @XmlAttribute(name = "DrawParam")
    var drawParam: Long? = null

    @XmlAttribute(name = "LineWidth")
    protected var lineWidth: Double? = null
        get() = field ?: 0.353

    @XmlAttribute(name = "Cap")
    protected var cap: String? = null
        get() = field ?: "Butt"

    @XmlAttribute(name = "Join")
    protected var join: String? = null
        get() = field ?: "Miter"

    @XmlAttribute(name = "MiterLimit")
    protected var miterLimit: Double? = null
        get() = field ?: 4.234

    @XmlAttribute(name = "DashOffset")
    protected var dashOffset: Double? = null
        get() = field ?: 0.0

    @XmlAttribute(name = "DashPattern")
    var dashPattern: String? = null

    @XmlAttribute(name = "Alpha")
    protected var alpha: Int? = null
        get() = field ?: 255


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["action"])
    class Actions {

        @XmlElement(name = "Action", required = true)
        protected var action: List<CTAction>? = null
            get() {
                if (field == null) {
                    field = ArrayList()
                }
                return field
            }
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["clip"])
    class Clips {
        @XmlElement(name = "Clip", required = true)
        protected var clip: List<CTClip>? = null
            get() {
                if (field == null) {
                    field = ArrayList()
                }
                return field
            }
    }
}