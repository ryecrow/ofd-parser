package org.ofdspec

import jakarta.xml.bind.annotation.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_Action", propOrder = ["region", "goto", "uri", "gotoA", "sound", "movie"])
class CTAction {

    @XmlElement(name = "Region")
    var region: CTRegion? = null

    @XmlElement(name = "Goto")
    var goto: Goto? = null

    @XmlElement(name = "URI")
    var uri: URI? = null

    @XmlElement(name = "GotoA")
    var gotoA: GotoA? = null

    @XmlElement(name = "Sound")
    var sound: Sound? = null

    @XmlElement(name = "Movie")
    var movie: Movie? = null

    @XmlAttribute(name = "Event", required = true)
    var event: String? = null

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["dest", "bookmark"])
    class Goto {

        @XmlElement(name = "Dest")
        var dest: CTDest? = null

        @XmlElement(name = "Bookmark")
        var bookmark: Bookmark? = null

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        class Bookmark {

            @XmlAttribute(name = "Name", required = true)
            var name: String? = null
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    class GotoA {

        @XmlAttribute(name = "AttachID", required = true)
        @XmlIDREF
        @XmlSchemaType(name = "IDREF")
        var attachID: Any? = null

        @XmlAttribute(name = "NewWindow")
        var newWindow: Boolean? = null
            get() = field ?: true
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    class Movie {

        @XmlAttribute(name = "ResourceID", required = true)
        var resourceID: Long = 0

        @XmlAttribute(name = "Operator")
        var operator: String? = null
            get() = field ?: "Play"
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    class Sound {

        @XmlAttribute(name = "ResourceID", required = true)
        var resourceID: Long = 0

        @XmlAttribute(name = "Volume")
        var volume: Int? = null

        @XmlAttribute(name = "Repeat")
        var repeat: Boolean? = null

        @XmlAttribute(name = "Synchronous")
        var synchronous: Boolean? = null
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    class URI {

        @XmlAttribute(name = "URI", required = true)
        var uri: String? = null

        @XmlAttribute(name = "Base")
        var base: String? = null

        @XmlAttribute(name = "Target")
        var target: String? = null
    }
}