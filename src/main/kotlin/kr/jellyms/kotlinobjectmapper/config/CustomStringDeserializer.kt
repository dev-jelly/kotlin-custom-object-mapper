package kr.jellyms.kotlinobjectmapper.config

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer

class CustomStringDeserializer: JsonDeserializer<String?>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): String? {
        return p?.text?.trim()
    }
}