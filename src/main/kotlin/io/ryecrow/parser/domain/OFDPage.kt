package io.ryecrow.parser.domain

/**
 * One page in an OFD document
 *
 * @author Rene Fang
 * @version 1.0
 */
data class OFDPage(
    var textContent: String,
    var nonTextObjects: List<Any>
)