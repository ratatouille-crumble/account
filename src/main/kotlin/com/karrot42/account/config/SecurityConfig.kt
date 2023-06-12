package com.karrot42.account.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.SecurityWebFiltersOrder
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.config.web.server.invoke
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.web.server.session.HeaderWebSessionIdResolver
import org.springframework.web.server.session.WebSessionIdResolver


@Configuration
@EnableWebFluxSecurity
class HelloWebfluxSecurityConfig {

    @Bean
    fun springSecurityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http {
            addFilterBefore(AccountAuthenticationFilter(), SecurityWebFiltersOrder.AUTHENTICATION)
            httpBasic { disable() }
            cors { disable() }

            authorizeExchange {
                authorize("/public/*", permitAll)
                authorize(anyExchange, authenticated)
            }
        }
    }

    @Bean
    fun webSessionIdResolver(): WebSessionIdResolver? {
        val sessionIdResolver = HeaderWebSessionIdResolver()
        // sessionId를 내려주는 이름
        //  sessionIdResolver.headerName = "example1"

        return sessionIdResolver
    }
}