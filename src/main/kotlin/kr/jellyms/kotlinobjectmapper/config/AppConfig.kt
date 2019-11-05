package kr.jellyms.kotlinobjectmapper.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class AppConfig: WebMvcConfigurer {
    @Bean
    fun jackson2HttpMessageConverter(): MappingJackson2HttpMessageConverter {
        val converter = MappingJackson2HttpMessageConverter()
        converter.objectMapper = CustomObjectMapper()
        return converter;
    }

    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        converters.add(jackson2HttpMessageConverter())
    }
}