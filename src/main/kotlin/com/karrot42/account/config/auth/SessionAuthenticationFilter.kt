package com.karrot42.account.config.auth

import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.web.server.authentication.AuthenticationWebFilter
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter
import org.springframework.stereotype.Component

@Component
class SessionAuthenticationFilter(
    reactiveAuthenticationManager: ReactiveAuthenticationManager,
    sessionAuthenticationConverter: ServerAuthenticationConverter,
) : AuthenticationWebFilter(reactiveAuthenticationManager) {

    init {
        super.setServerAuthenticationConverter(sessionAuthenticationConverter)
    }
}
