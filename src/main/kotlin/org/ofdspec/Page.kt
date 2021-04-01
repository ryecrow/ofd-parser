package org.ofdspec

import jakarta.xml.bind.annotation.*
import java.util.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["template", "pageRes", "area", "content", "actions"])
@XmlRootElement(name = "Page")
class Page {
    @XmlElement(name = "Template")
    var template: List<Template>? = null
        get() {
            if (field == null) {
                field = ArrayList()
            }
            return field
        }

    @XmlElement(name = "PageRes")
    @XmlSchemaType(name = "anyURI")
    var pageRes: List<String>? = null
        get() {
            if (field == null) {
                field = ArrayList()
            }
            return field
        }

    @XmlElement(name = "Area")
    var area: CTPageArea? = null

    @XmlElement(name = "Content")
    var content: Content? = null

    @XmlElement(name = "Actions")
    var actions: Actions? = null

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["action"])
    class Actions {
        @XmlElement(name = "Action", required = true)
        var action: List<CTAction>? = null
            get() {
                if (field == null) {
                    field = ArrayList()
                }
                return field
            }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["layer"])
    class Content {
        @XmlElement(name = "Layer", required = true)
        var layer: List<Layer>? = null
            get() {
                if (field == null) {
                    field = ArrayList()
                }
                return field
            }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        class Layer : CTLayer() {

            @XmlAttribute(name = "ID", required = true)
            var id: Long = 0
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    class Template {

        @XmlAttribute(name = "TemplateID", required = true)
        var templateID: Long = 0

        @XmlAttribute(name = "ZOrder")
        var zOrder: String? = null
            get() = field ?: "Background"
    }
}