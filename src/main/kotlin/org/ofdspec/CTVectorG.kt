package org.ofdspec

import jakarta.xml.bind.annotation.*
import org.ofdspec.Res.CompositeGraphicUnits.CompositeGraphicUnit

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_VectorG", propOrder = ["thumbnail", "substitution", "content"])
@XmlSeeAlso(
    CompositeGraphicUnit::class
)
open class CTVectorG {

    @XmlElement(name = "Thumbnail")
    @XmlSchemaType(name = "unsignedInt")
    var thumbnail: Long? = null

    @XmlElement(name = "Substitution")
    @XmlSchemaType(name = "unsignedInt")
    var substitution: Long? = null

    @XmlElement(name = "Content", required = true)
    var content: CTPageBlock? = null

    @XmlAttribute(name = "Width", required = true)
    var width = 0.0

    @XmlAttribute(name = "Height", required = true)
    var height = 0.0
}