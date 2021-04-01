package org.ofdspec

import jakarta.xml.bind.annotation.*
import java.util.*
import javax.xml.datatype.XMLGregorianCalendar

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_Extension", propOrder = ["propertyOrDataOrExtendData"])
class CTExtension {

    @XmlElements(
        XmlElement(name = "Property", type = Property::class),
        XmlElement(name = "Data"),
        XmlElement(name = "ExtendData", type = String::class)
    )
    var propertyOrDataOrExtendData: List<Any>? = null
        get() {
            if (field == null) {
                field = ArrayList()
            }
            return field
        }

    @XmlAttribute(name = "AppName", required = true)
    var appName: String? = null

    @XmlAttribute(name = "Company")
    var company: String? = null

    @XmlAttribute(name = "AppVersion")
    var appVersion: String? = null

    @XmlAttribute(name = "Date")
    @XmlSchemaType(name = "dateTime")
    var date: XMLGregorianCalendar? = null

    @XmlAttribute(name = "RefId", required = true)
    var refId: Long = 0

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["value"])
    class Property {

        @XmlValue
        var value: String? = null

        @XmlAttribute(name = "Name", required = true)
        var name: String? = null

        @XmlAttribute(name = "Type")
        var type: String? = null
    }
}