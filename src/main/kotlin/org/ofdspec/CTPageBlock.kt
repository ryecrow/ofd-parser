package org.ofdspec

import jakarta.xml.bind.annotation.*
import org.ofdspec.CTPageBlock.PageBlock
import org.ofdspec.CTPattern.CellContent
import org.ofdspec.PageAnnot.Annot.Appearance
import java.util.*


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_PageBlock", propOrder = ["textObjectOrPathObjectOrImageObject"])
@XmlSeeAlso(
    Appearance::class, CTLayer::class, PageBlock::class, CellContent::class
)
open class CTPageBlock {

    @XmlElements(
        XmlElement(name = "TextObject", type = TextObject::class),
        XmlElement(name = "PathObject", type = PathObject::class),
        XmlElement(name = "ImageObject", type = ImageObject::class),
        XmlElement(name = "CompositeObject", type = CompositeObject::class),
        XmlElement(name = "PageBlock", type = PageBlock::class)
    )
    protected var textObjectOrPathObjectOrImageObject: List<Any>? = null
        get() {
            if (field == null) {
                field = ArrayList()
            }
            return field
        }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    class CompositeObject : CTComposite() {

        @XmlAttribute(name = "ID", required = true)
        var id: Long = 0
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    class ImageObject : CTImage() {

        @XmlAttribute(name = "ID", required = true)
        var id: Long = 0
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    class PageBlock : CTPageBlock() {

        @XmlAttribute(name = "ID", required = true)
        var id: Long = 0
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    class PathObject : CTPath() {

        @XmlAttribute(name = "ID", required = true)
        var id: Long = 0
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    class TextObject : CTText() {

        @XmlAttribute(name = "ID", required = true)
        var id: Long = 0
    }
}