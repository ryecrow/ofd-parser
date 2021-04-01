package io.ryecrow.parser.domain

import org.ofdspec.CTDocInfo
import java.util.*

/**
 * Wrapper class of an OFD document
 *
 * @author Rene Fang
 * @version 1.0
 */
class OFDocument constructor(private val docInfo: CTDocInfo) {

    var pages: List<OFDPage> = emptyList()

    val title: String?
        get() = docInfo.title

    val author: String?
        get() = docInfo.author

    val abstract: String?
        get() = docInfo.abstract

    val creator: String?
        get() = docInfo.creator

    val creationDate: Date?
        get() = docInfo.creationDate?.toGregorianCalendar()?.time

    val keywords: List<String>
        get() = docInfo.keywords?.keyword ?: emptyList()
}