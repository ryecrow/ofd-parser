package org.ofdspec

import jakarta.xml.bind.annotation.*
import java.util.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["customTag"])
@XmlRootElement(name = "CustomTags")
class CustomTags {

    @XmlElement(name = "CustomTag")
    protected var customTag: List<CustomTag>? = null
        get() {
            if (field == null) {
                field = ArrayList()
            }
            return field
        }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["schemaLoc", "fileLoc"])
    class CustomTag {

        @XmlElement(name = "SchemaLoc")
        @XmlSchemaType(name = "anyURI")
        var schemaLoc: String? = null

        @XmlElement(name = "FileLoc", required = true)
        @XmlSchemaType(name = "anyURI")
        var fileLoc: String? = null

        @XmlAttribute(name = "NameSpace", required = true)
        var nameSpace: String? = null
    }
}