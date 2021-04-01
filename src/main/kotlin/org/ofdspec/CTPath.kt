package org.ofdspec

import jakarta.xml.bind.annotation.*
import org.ofdspec.CTPageBlock.PathObject


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_Path", propOrder = ["strokeColor", "fillColor", "abbreviatedData"])
@XmlSeeAlso(
    PathObject::class
)
open class CTPath : CTGraphicUnit() {

    @XmlElement(name = "StrokeColor")
    var strokeColor: CTColor? = null

    @XmlElement(name = "FillColor")
    var fillColor: CTColor? = null

    @XmlElement(name = "AbbreviatedData", required = true)
    var abbreviatedData: String? = null

    @XmlAttribute(name = "Stroke")
    var stroke: Boolean? = null
        get() = field ?: true

    @XmlAttribute(name = "Fill")
    var fill: Boolean? = null
        get() = field ?: false

    @XmlAttribute(name = "Rule")
    var rule: String? = null
        get() = field ?: "NonZero"
}