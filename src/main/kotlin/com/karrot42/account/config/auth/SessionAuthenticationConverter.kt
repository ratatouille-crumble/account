package com.karrot42.account.config.auth

import org.springframework.security.core.Authentication
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component
class SessionAuthenticationConverter : ServerAuthenticationConverter {

    override fun convert(exchange: ServerWebExchange?): Mono<Authentication> =
        Mono.justOrEmpty(exchange?.request?.headers?.getFirst(SESSION_COOKIE_NAME))
            .map { SessionAuthenticationToken.fromCookie(it) }

    companion object {
        const val SESSION_COOKIE_NAME = "session"
    }
}
