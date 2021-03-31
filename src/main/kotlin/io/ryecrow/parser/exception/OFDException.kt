package io.ryecrow.parser.exception

/**
 * Exception used when parsing OFD documents
 *
 * @author Rene Fang
 * @version 1.0
 */
class OFDException : Exception {

    constructor() : super()
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable) : super(cause)
}