package org.ofdspec

import jakarta.xml.bind.annotation.*
import java.util.*
import javax.xml.datatype.XMLGregorianCalendar

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "CT_DocInfo",
    propOrder = ["docID", "title", "author", "subject", "abstract", "creationDate", "modDate", "docUsage", "cover", "keywords", "creator", "creatorVersion", "customDatas"]
)
class CTDocInfo {

    @XmlElement(name = "DocID", required = true)
    var docID: String? = null

    @XmlElement(name = "Title")
    var title: String? = null

    @XmlElement(name = "Author")
    var author: String? = null

    @XmlElement(name = "Subject")
    var subject: String? = null

    @XmlElement(name = "Abstract")
    var abstract: String? = null

    @XmlElement(name = "CreationDate")
    @XmlSchemaType(name = "date")
    var creationDate: XMLGregorianCalendar? = null

    @XmlElement(name = "ModDate")
    @XmlSchemaType(name = "date")
    var modDate: XMLGregorianCalendar? = null

    @XmlElement(name = "DocUsage")
    var docUsage: String? = null

    @XmlElement(name = "Cover")
    @XmlSchemaType(name = "anyURI")
    var cover: String? = null

    @XmlElement(name = "Keywords")
    var keywords: Keywords? = null

    @XmlElement(name = "Creator")
    var creator: String? = null

    @XmlElement(name = "CreatorVersion")
    var creatorVersion: String? = null

    @XmlElement(name = "CustomDatas")
    var customDatas: CustomDatas? = null

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["customData"])
    class CustomDatas {
        @XmlElement(name = "CustomData", required = true)
        protected var customData: List<CustomData>? = null
            get() {
                if (field == null) {
                    field = ArrayList()
                }
                return field
            }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = ["value"])
        class CustomData {

            @XmlValue
            var value: String? = null

            @XmlAttribute(name = "Name", required = true)
            var name: String? = null
        }
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["keyword"])
    class Keywords {
        @XmlElement(name = "Keyword", required = true)
        protected var keyword: List<String>? = null
            get() {
                if (field == null) {
                    field = ArrayList()
                }
                return field
            }
    }
}