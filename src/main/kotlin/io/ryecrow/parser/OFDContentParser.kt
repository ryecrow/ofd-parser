package io.ryecrow.parser

import org.apache.tika.metadata.Metadata
import org.apache.tika.mime.MediaType
import org.apache.tika.parser.AbstractParser
import org.apache.tika.parser.ParseContext
import org.xml.sax.ContentHandler
import java.io.InputStream

class OFDContentParser : AbstractParser() {

    override fun getSupportedTypes(context: ParseContext): Set<MediaType> {
        return emptySet()
    }

    override fun parse(stream: InputStream?, handler: ContentHandler?, metadata: Metadata?, context: ParseContext?) {
        TODO("Not yet implemented")
    }
}