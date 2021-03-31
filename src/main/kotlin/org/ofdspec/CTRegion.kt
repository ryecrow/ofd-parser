package org.ofdspec

import jakarta.xml.bind.annotation.*
import java.util.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_Region", propOrder = ["area"])
class CTRegion {
    @XmlElement(name = "Area", required = true)
    protected var area: List<Area>? = null
        get() {
            if (field == null) {
                field = ArrayList()
            }
            return field
        }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = ["moveOrLineOrQuadraticBezier"])
    class Area {

        @XmlElements(
            XmlElement(name = "Move", type = Move::class),
            XmlElement(name = "Line", type = Line::class),
            XmlElement(name = "QuadraticBezier", type = QuadraticBezier::class),
            XmlElement(name = "CubicBezier", type = CubicBezier::class),
            XmlElement(name = "Arc", type = Arc::class),
            XmlElement(name = "Close")
        )
        protected var moveOrLineOrQuadraticBezier: List<Any>? = null
            get() {
                if (field == null) {
                    field = ArrayList()
                }
                return field
            }

        @XmlAttribute(name = "Start", required = true)
        var start: String? = null

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        class Arc {

            @XmlAttribute(name = "SweepDirection", required = true)
            var sweepDirection = false

            @XmlAttribute(name = "LargeArc", required = true)
            var largeArc = false

            @XmlAttribute(name = "RotationAngle", required = true)
            var rotationAngle = 0.0

            @XmlAttribute(name = "EllipseSize", required = true)
            var ellipseSize: String? = null

            @XmlAttribute(name = "EndPoint", required = true)
            var endPoint: String? = null
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        class CubicBezier {

            @XmlAttribute(name = "Point1")
            var point1: String? = null

            @XmlAttribute(name = "Point2")
            var point2: String? = null

            @XmlAttribute(name = "Point3", required = true)
            var point3: String? = null
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        class Line {

            @XmlAttribute(name = "Point1", required = true)
            var point1: String? = null
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        class Move {

            @XmlAttribute(name = "Point1", required = true)
            var point1: String? = null
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        class QuadraticBezier {

            @XmlAttribute(name = "Point1", required = true)
            var point1: String? = null

            @XmlAttribute(name = "Point2", required = true)
            var point2: String? = null
        }
    }
}