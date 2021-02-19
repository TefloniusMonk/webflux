package com.example.webflux.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class PropertyConfig(
    @Value("\${app.baseUrl}")
    private val baseUrl: String,
    @Value("\${app.basePort}")
    private val basePort: Int
) {
    fun baseUrl(): String {
        return baseUrl
    }

    fun basePort(): Int {
        return basePort
    }
}