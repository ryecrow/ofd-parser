package org.ofdspec

import jakarta.xml.bind.annotation.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["attachment"])
@XmlRootElement(name = "Attachments")
class Attachments {

    @XmlElement(name = "Attachment")
    protected var attachment: List<CTAttachment>? = null
        get() {
            if (field == null) {
                field = ArrayList()
            }
            return field
        }
}