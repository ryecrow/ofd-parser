package io.ryecrow.parser.util

import jakarta.xml.bind.JAXBContext
import java.util.*

/**
 * Factory method to provide instantiated JAXB context
 *
 * @author Rene Fang
 * @version 1.0
 */
val CONTEXTS: MutableMap<String, JAXBContext> = HashMap()

object JAXBContexts {
    operator fun get(clazz: Any): JAXBContext {
        return if (CONTEXTS.containsKey(clazz.javaClass.canonicalName)) {
            CONTEXTS[clazz.javaClass.canonicalName]!!
        } else {
            val jaxbContext: JAXBContext = JAXBContext.newInstance(clazz.javaClass)
            CONTEXTS[clazz.javaClass.canonicalName] = jaxbContext
            jaxbContext
        }
    }
}