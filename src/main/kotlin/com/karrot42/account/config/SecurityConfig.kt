package com.karrot42.account.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.SecurityWebFiltersOrder
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.config.web.server.invoke
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.web.server.authentication.AuthenticationWebFilter
import org.springframework.security.web.server.authentication.HttpStatusServerEntryPoint
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers.pathMatchers
import reactor.core.publisher.Mono

@EnableWebFluxSecurity
@Configuration
class SecurityConfig {

    @Bean
    fun authenticationManager(): ReactiveAuthenticationManager =
        ReactiveAuthenticationManager { Mono.just(it) }

    @Bean
    fun springSecurityFilterChain(
        http: ServerHttpSecurity,
        manager: ReactiveAuthenticationManager,
    ): SecurityWebFilterChain {
        return http {
            authorizeExchange {
                authorize(pathMatchers("/api/v1/sign-in"), permitAll)
                authorize(pathMatchers("/api/v1/**"), authenticated)
                authorize(anyExchange, denyAll)
            }
            addFilterAt(authenticationFilter(manager), SecurityWebFiltersOrder.AUTHENTICATION)
            csrf { disable() }
            formLogin { disable() }
            httpBasic { disable() }
            logout { disable() }

            exceptionHandling {
                authenticationEntryPoint = HttpStatusServerEntryPoint(HttpStatus.NOT_FOUND)
            }
        }
    }

    private fun authenticationFilter(manager: ReactiveAuthenticationManager): AuthenticationWebFilter {
        val bearerAuthenticationFilter = AuthenticationWebFilter(manager)

        bearerAuthenticationFilter.setServerAuthenticationConverter { exchange ->
            exchange.session.mapNotNull {
                when (val user = it.getAttribute<Long>("user")) {
                    null -> null
                    else ->
                        UsernamePasswordAuthenticationToken(
                            /* principal = */
                            user,
                            /* credentials = */
                            "USER",
                            /* authorities = */
                            listOf(SimpleGrantedAuthority("ROLE_USER")),
                        )
                }
            }
        }

        return bearerAuthenticationFilter
    }
}
