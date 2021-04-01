package org.ofdspec

import jakarta.xml.bind.annotation.*
import java.util.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = ["commonData", "pages", "outlines", "permissions", "actions", "vPreferences", "bookmarks", "annotations", "customTags", "attachments", "extensions"]
)
@XmlRootElement(name = "Document")
class Document {

    @XmlElement(name = "CommonData", required = true)
    var commonData: CommonData? = null

    @XmlElement(name = "Pages", required = true)
    var pages: Pages? = null

    @XmlElement(name = "Outlines")
    var outlines: Outlines? = null

    @XmlElement(name = "Permissions")
    var permissions: CTPermission? = null

    @XmlElement(name = "Actions")
    var actions: Actions? = null

    @XmlElement(name = "VPreferences")
    var vPreferences: CTVPreferences? = null

    @XmlElement(name = "Bookmarks")
    var bookmarks: Bookmarks? = null

    @XmlElement(name = "Annotations")
    @XmlSchemaType(name = "anyURI")
    var annotations: String? = null

    @XmlElement(name = "CustomTags")
    @XmlSchemaType(name = "anyURI")
    var customTags: String? = null

    @XmlElement(name = "Attachments")
    @XmlSchemaType(name = "anyURI")
    var attachments: String? = null

    @XmlElement(name = "Extensions")
    @XmlSchemaType(name = "anyURI")
    var extensions: String? = null

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
    @XmlType(name = "", propOrder = ["bookmark"])
    class Bookmarks {
        @XmlElement(name = "Bookmark", required = true)
        var bookmark: List<CTBookmark>? = null
            get() {
                if (field == null) {
                    field = ArrayList()
                }
                return field
            }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["maxUnitID", "pageArea", "publicRes", "documentRes", "templatePage", "defaultCS"])
    class CommonData {

        @XmlElement(name = "MaxUnitID")
        @XmlSchemaType(name = "unsignedInt")
        var maxUnitID: Long = 0

        @XmlElement(name = "PageArea", required = true)
        var pageArea: CTPageArea? = null

        @XmlElement(name = "PublicRes")
        @XmlSchemaType(name = "anyURI")
        var publicRes: List<String>? = null
            get() {
                if (field == null) {
                    field = ArrayList()
                }
                return field
            }

        @XmlElement(name = "DocumentRes")
        @XmlSchemaType(name = "anyURI")
        var documentRes: List<String>? = null
            get() {
                if (field == null) {
                    field = ArrayList()
                }
                return field
            }

        @XmlElement(name = "TemplatePage")
        var templatePage: List<TemplatePage>? = null
            get() {
                if (field == null) {
                    field = ArrayList()
                }
                return field
            }

        @XmlElement(name = "DefaultCS")
        @XmlSchemaType(name = "unsignedInt")
        var defaultCS: Long? = null

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        class TemplatePage {

            @XmlAttribute(name = "ID", required = true)
            var id: Long = 0

            @XmlAttribute(name = "Name")
            var name: String? = null

            @XmlAttribute(name = "ZOrder")
            var zOrder: String? = null

            @XmlAttribute(name = "BaseLoc", required = true)
            var baseLoc: String? = null
        }
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["outlineElem"])
    class Outlines {
        @XmlElement(name = "OutlineElem", required = true)
        var outlineElem: List<CTOutlineElem>? = null
            get() {
                if (field == null) {
                    field = ArrayList()
                }
                return field
            }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["page"])
    class Pages {
        @XmlElement(name = "Page", required = true)
        var page: List<Page>? = null
            get() {
                if (field == null) {
                    field = ArrayList()
                }
                return field
            }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        class Page {

            @XmlAttribute(name = "ID", required = true)
            var id: Long = 0

            @XmlAttribute(name = "BaseLoc", required = true)
            var baseLoc: String? = null
        }
    }
}