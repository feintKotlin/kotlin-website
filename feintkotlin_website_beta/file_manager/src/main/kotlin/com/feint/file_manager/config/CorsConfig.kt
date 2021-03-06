package com.feint.file_manager.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.filter.CorsFilter


@Configuration
class CorsConfig {
    private fun buildConfig(): CorsConfiguration {
        val corsConfiguration = CorsConfiguration()
        corsConfiguration.addAllowedOrigin("*") // 1
        corsConfiguration.addAllowedHeader("*") // 2
        corsConfiguration.addAllowedMethod("*") // 3
        return corsConfiguration
    }

    @Bean
    fun corsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", buildConfig()) // 4
        return CorsFilter(source)
    }
}