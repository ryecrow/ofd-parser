package org.ofdspec

import jakarta.xml.bind.annotation.*
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter
import java.util.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["signedInfo", "signedValue"])
@XmlRootElement(name = "Signature")
class Signature {

    @XmlElement(name = "SignedInfo", required = true)
    var signedInfo: SignedInfo? = null

    @XmlElement(name = "SignedValue", required = true)
    @XmlSchemaType(name = "anyURI")
    var signedValue: String? = null

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(
        name = "",
        propOrder = ["provider", "signatureMethod", "signatureDateTime", "references", "stampAnnot", "seal"]
    )
    class SignedInfo {

        @XmlElement(name = "Provider", required = true)
        var provider: Provider? = null

        @XmlElement(name = "SignatureMethod")
        var signatureMethod: String? = null

        @XmlElement(name = "SignatureDateTime")
        var signatureDateTime: String? = null

        @XmlElement(name = "References", required = true)
        var references: References? = null

        @XmlElement(name = "StampAnnot")
        protected var stampAnnot: List<StampAnnot>? = null
            get() {
                if (field == null) {
                    field = ArrayList()
                }
                return field
            }

        @XmlElement(name = "Seal")
        var seal: Seal? = null

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        class Provider {

            @XmlAttribute(name = "ProviderName", required = true)
            var providerName: String? = null

            @XmlAttribute(name = "Version")
            var version: String? = null

            @XmlAttribute(name = "Company")
            var company: String? = null
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = ["reference"])
        class References {
            @XmlElement(name = "Reference", required = true)
            protected var reference: List<Reference>? = null
                get() {
                    if (field == null) {
                        field = ArrayList()
                    }
                    return field
                }

            @XmlAttribute(name = "CheckMethod")
            protected var checkMethod: String? = null
                get() = field ?: "MD5"

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = ["checkValue"])
            class Reference {

                @XmlElement(name = "CheckValue", required = true)
                var checkValue: ByteArray? = null

                @XmlAttribute(name = "FileRef", required = true)
                var fileRef: String? = null
            }
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = ["baseLoc"])
        class Seal {

            @XmlElement(name = "BaseLoc", required = true)
            @XmlSchemaType(name = "anyURI")
            var baseLoc: String? = null
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        class StampAnnot {

            @XmlAttribute(name = "ID", required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter::class)
            @XmlID
            @XmlSchemaType(name = "ID")
            var id: String? = null

            @XmlAttribute(name = "PageRef", required = true)
            var pageRef: Long = 0

            @XmlAttribute(name = "Boundary", required = true)
            var boundary: String? = null

            @XmlAttribute(name = "Clip")
            var clip: String? = null
        }
    }
}