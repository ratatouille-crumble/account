package com.karrot42.account.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.SecurityWebFiltersOrder
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.config.web.server.invoke
import org.springframework.security.web.server.util.matcher.PathPatternParserServerWebExchangeMatcher

@Configuration
@EnableWebFluxSecurity
class HelloWebfluxSecurityConfig {

    @Bean
    fun springSecurityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http {
            securityMatcher(PathPatternParserServerWebExchangeMatcher("/api/**"))
            formLogin { disable() }
            httpBasic { disable() }

            authorizeExchange {
                authorize("/login", permitAll)
                authorize(anyExchange, authenticated)
            }
        }
    }
}