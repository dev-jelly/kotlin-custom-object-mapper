package kr.jellyms.kotlinobjectmapper.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule

class CustomObjectMapper : ObjectMapper() {
    init {
        val kotlinModule = KotlinModule()
        kotlinModule.addSerializer(String::class.java, CustomStringSerializer())
        kotlinModule.addDeserializer(String::class.java, CustomStringDeserializer())
        registerModule(kotlinModule)
    }
}