package org.ofdspec

import jakarta.xml.bind.annotation.*
import org.ofdspec.Res.MultiMedias.MultiMedia

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_MultiMedia", propOrder = ["mediaFile"])
@XmlSeeAlso(
    MultiMedia::class
)
open class CTMultiMedia {

    @XmlElement(name = "MediaFile", required = true)
    @XmlSchemaType(name = "anyURI")
    var mediaFile: String? = null

    @XmlAttribute(name = "Type", required = true)
    var type: String? = null

    @XmlAttribute(name = "Format")
    var format: String? = null
}