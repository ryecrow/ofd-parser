package org.ofdspec

import jakarta.xml.bind.annotation.XmlAccessType
import jakarta.xml.bind.annotation.XmlAccessorType
import jakarta.xml.bind.annotation.XmlElement
import jakarta.xml.bind.annotation.XmlType

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "CT_VPreferences",
    propOrder = ["pageMode", "pageLayout", "tabDisplay", "hideToolbar", "hideMenubar", "hideWindowUI", "zoomMode", "zoom"]
)
class CTVPreferences {

    @XmlElement(name = "PageMode", defaultValue = "None")
    var pageMode: String? = null

    @XmlElement(name = "PageLayout", defaultValue = "OneColumn")
    var pageLayout: String? = null

    @XmlElement(name = "TabDisplay", defaultValue = "DocTitle")
    var tabDisplay: String? = null

    @XmlElement(name = "HideToolbar", defaultValue = "false")
    var hideToolbar: Boolean? = null

    @XmlElement(name = "HideMenubar", defaultValue = "false")
    var hideMenubar: Boolean? = null

    @XmlElement(name = "HideWindowUI", defaultValue = "false")
    var hideWindowUI: Boolean? = null

    @XmlElement(name = "ZoomMode")
    var zoomMode: String? = null

    @XmlElement(name = "Zoom")
    var zoom: Double? = null
}