package io.ryecrow.parser.domain

import org.ofdspec.OFD

/**
 * Wrapper class of an OFD document
 *
 * @author Rene Fang
 * @version 1.0
 */
class OFDocument constructor(private val ofd: OFD) {

    val version: String
        get() = ofd.version ?: "1.0"


}