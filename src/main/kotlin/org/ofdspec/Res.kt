package org.ofdspec

import jakarta.xml.bind.annotation.*
import java.util.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = ["colorSpacesOrDrawParamsOrFonts"])
@XmlRootElement(name = "Res")
class Res {
    @XmlElements(
        XmlElement(name = "ColorSpaces", type = ColorSpaces::class),
        XmlElement(name = "DrawParams", type = DrawParams::class),
        XmlElement(name = "Fonts", type = Fonts::class),
        XmlElement(name = "MultiMedias", type = MultiMedias::class),
        XmlElement(name = "CompositeGraphicUnits", type = CompositeGraphicUnits::class)
    )
    var colorSpacesOrDrawParamsOrFonts: List<Any>? = null
        get() {
            if (field == null) {
                field = ArrayList()
            }
            return field
        }

    @XmlAttribute(name = "BaseLoc", required = true)
    var baseLoc: String? = null

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["colorSpace"])
    class ColorSpaces {
        @XmlElement(name = "ColorSpace", required = true)
        var colorSpace: List<ColorSpace>? = null
            get() {
                if (field == null) {
                    field = ArrayList()
                }
                return field
            }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        class ColorSpace : CTColorSpace() {

            @XmlAttribute(name = "ID", required = true)
            var id: Long = 0
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["compositeGraphicUnit"])
    class CompositeGraphicUnits {
        @XmlElement(name = "CompositeGraphicUnit", required = true)
        var compositeGraphicUnit: List<CompositeGraphicUnit>? = null
            get() {
                if (field == null) {
                    field = ArrayList()
                }
                return field
            }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        class CompositeGraphicUnit : CTVectorG() {

            @XmlAttribute(name = "ID", required = true)
            var id: Long = 0
        }
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["drawParam"])
    class DrawParams {
        @XmlElement(name = "DrawParam", required = true)
        var drawParam: List<DrawParam>? = null
            get() {
                if (field == null) {
                    field = ArrayList()
                }
                return field
            }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        class DrawParam : CTDrawParam() {

            @XmlAttribute(name = "ID", required = true)
            var id: Long = 0
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["font"])
    class Fonts {
        @XmlElement(name = "Font", required = true)
        var font: List<Font>? = null
            get() {
                if (field == null) {
                    field = ArrayList()
                }
                return field
            }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        class Font : CTFont() {

            @XmlAttribute(name = "ID", required = true)
            var id: Long = 0
        }
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["multiMedia"])
    class MultiMedias {
        @XmlElement(name = "MultiMedia", required = true)
        var multiMedia: List<MultiMedia>? = null
            get() {
                if (field == null) {
                    field = ArrayList()
                }
                return field
            }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        class MultiMedia : CTMultiMedia() {

            @XmlAttribute(name = "ID", required = true)
            var id: Long = 0
        }
    }
}