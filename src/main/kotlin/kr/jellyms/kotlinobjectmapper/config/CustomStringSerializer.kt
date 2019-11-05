package kr.jellyms.kotlinobjectmapper.config

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider

class CustomStringSerializer: JsonSerializer<String?>() {
    override fun serialize(value: String?, gen: JsonGenerator?, serializers: SerializerProvider?) {
        gen?.writeString(value?.trim())
    }
}