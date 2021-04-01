package org.ofdspec

import jakarta.xml.bind.annotation.*
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter
import java.util.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["docBody"])
@XmlRootElement(name = "OFD")
class OFD {

    @XmlElement(name = "DocBody", required = true)
    var docBody: List<DocBody>? = null
        get() {
            if (field == null) {
                field = ArrayList()
            }
            return field
        }

    @XmlAttribute(name = "Version", required = true)
    var version: String? = "1.0"

    @XmlAttribute(name = "DocType", required = true)
    var docType: String? = "OFD"


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["docInfo", "docRoot", "versions", "signatures"])
    class DocBody {

        @XmlElement(name = "DocInfo", required = true)
        var docInfo: CTDocInfo? = null

        @XmlElement(name = "DocRoot", required = true)
        @XmlSchemaType(name = "anyURI")
        var docRoot: String? = null

        @XmlElement(name = "Versions")
        var versions: Versions? = null

        @XmlElement(name = "Signatures")
        @XmlSchemaType(name = "anyURI")
        var signatures: String? = null

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = ["version"])
        class Versions {
            @XmlElement(name = "Version", required = true)
            var version: List<Version>? = null
                get() {
                    if (field == null) {
                        field = ArrayList()
                    }
                    return field
                }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            class Version {

                @XmlAttribute(name = "ID", required = true)
                @XmlJavaTypeAdapter(CollapsedStringAdapter::class)
                @XmlID
                @XmlSchemaType(name = "ID")
                var id: String? = null

                @XmlAttribute(name = "Index", required = true)
                var index = 0

                @XmlAttribute(name = "Current")
                var current: Boolean = false

                @XmlAttribute(name = "BaseLoc", required = true)
                var baseLoc: String? = null
            }
        }
    }
}