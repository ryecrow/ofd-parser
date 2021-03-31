package org.ofdspec

import jakarta.xml.bind.annotation.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_Color", propOrder = ["pattern", "axialShd", "radialShd", "gouraudShd", "laGourandShd"])
class CTColor {

    @XmlElement(name = "Pattern")
    var pattern: CTPattern? = null

    @XmlElement(name = "AxialShd")
    var axialShd: CTAxialShd? = null

    @XmlElement(name = "RadialShd")
    var radialShd: CTRadialShd? = null

    @XmlElement(name = "GouraudShd")
    var gouraudShd: CTGouraudShd? = null

    @XmlElement(name = "LaGourandShd")
    var laGourandShd: CTLaGouraudShd? = null

    @XmlAttribute(name = "Value")
    var value: String? = null

    @XmlAttribute(name = "Index")
    var index: Int? = null

    @XmlAttribute(name = "ColorSpace")
    var colorSpace: Long? = null

    @XmlAttribute(name = "Alpha")
    protected var alpha: Int? = null
        get() = field ?: 255
}