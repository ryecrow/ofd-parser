package io.ryecrow.parser.domain

/**
 * One page in an OFD document
 *
 * @author Rene Fang
 * @version 1.0
 */
data class OFDPage(
    var text: String,
    var paths: List<Any>,
    var images: List<Any>,
    var blocks: List<Any>,
    var compositeObjects: List<Any>
)