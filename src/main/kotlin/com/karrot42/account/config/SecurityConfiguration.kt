package com.karrot42.account.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.SecurityWebFiltersOrder
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.config.web.server.invoke
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.web.server.authentication.AuthenticationWebFilter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.reactive.CorsConfigurationSource
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
class SecurityConfiguration {

    @Bean
    fun securityWebFilterChain(
        http: ServerHttpSecurity,
        corsConfigurationSource: CorsConfigurationSource,
        sessionAuthenticationFilter: AuthenticationWebFilter,
    ): SecurityWebFilterChain =
        http {
            csrf { disable() }
            cors {
                configurationSource = corsConfigurationSource
            }
            formLogin { disable() }
            logout { disable() }
            authorizeExchange {
                authorize("/", permitAll)
                authorize(anyExchange, authenticated)
            }
            addFilterBefore(sessionAuthenticationFilter, SecurityWebFiltersOrder.HTTP_BASIC)
        }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource =
        UrlBasedCorsConfigurationSource().apply {
            val corsConfiguration = CorsConfiguration().apply {
                allowedOrigins = listOf("http://localhost:3000")
                allowedMethods = listOf("*")
                allowedHeaders = listOf("*")
                allowCredentials = true
            }
            registerCorsConfiguration("/**", corsConfiguration)
        }
}
