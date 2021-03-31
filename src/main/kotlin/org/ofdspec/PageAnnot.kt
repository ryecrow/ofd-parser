package org.ofdspec

import jakarta.xml.bind.annotation.*
import java.util.*
import javax.xml.datatype.XMLGregorianCalendar


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["annot"])
@XmlRootElement(name = "PageAnnot")
class PageAnnot {
    @XmlElement(name = "Annot", required = true)
    protected var annot: List<Annot>? = null
        get() {
            if (field == null) {
                field = ArrayList()
            }
            return field
        }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["remark", "parameters", "appearance"])
    class Annot {

        @XmlElement(name = "Remark")
        var remark: String? = null

        @XmlElement(name = "Parameters")
        var parameters: Parameters? = null

        @XmlElement(name = "Appearance", required = true)
        var appearance: Appearance? = null

        @XmlAttribute(name = "ID", required = true)
        var id: Long = 0

        @XmlAttribute(name = "Type", required = true)
        var type: String? = null

        @XmlAttribute(name = "Creator", required = true)
        var creator: String? = null

        @XmlAttribute(name = "LastModDate", required = true)
        @XmlSchemaType(name = "date")
        var lastModDate: XMLGregorianCalendar? = null

        @XmlAttribute(name = "Visible")
        protected var visible: Boolean = true

        @XmlAttribute(name = "Subtype")
        var subtype: String? = null

        @XmlAttribute(name = "Print")
        protected var print: Boolean = true

        @XmlAttribute(name = "NoZoom")
        protected var noZoom: Boolean = false

        @XmlAttribute(name = "NoRotate")
        protected var noRotate: Boolean = false

        @XmlAttribute(name = "ReadOnly")
        protected var readOnly: Boolean? = null
            get() = field ?: true


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        class Appearance : CTPageBlock() {

            @XmlAttribute(name = "Boundary")
            var boundary: String? = null
        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = ["parameter"])
        class Parameters {
            @XmlElement(name = "Parameter", required = true)
            protected var parameter: List<Parameter>? = null
                get() {
                    if (field == null) {
                        field = ArrayList()
                    }
                    return field
                }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = ["value"])
            class Parameter {

                @XmlValue
                var value: String? = null

                @XmlAttribute(name = "Name", required = true)
                var name: String? = null
            }
        }
    }
}