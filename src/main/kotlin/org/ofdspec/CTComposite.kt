package org.ofdspec

import jakarta.xml.bind.annotation.*
import org.ofdspec.CTPageBlock.CompositeObject

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_Composite")
@XmlSeeAlso(
    CompositeObject::class
)
open class CTComposite : CTGraphicUnit() {

    @XmlAttribute(name = "ResourceID", required = true)
    var resourceID: Long = 0
}