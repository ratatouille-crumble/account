package com.karrot42.account.config.auth

import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty

@Component
class SessionAuthenticationManager(
    private val userDetailsService: ReactiveUserDetailsService,
) : ReactiveAuthenticationManager {

    override fun authenticate(authentication: Authentication): Mono<Authentication> =
        userDetailsService.findByUsername(authentication.name)
            .switchIfEmpty { Mono.just(AnonymousUserDetail.INSTANCE) }
            .map(this::toAuthentication)

    private fun toAuthentication(user: UserDetails): Authentication =
        when (user) {
            is AnonymousUserDetail -> SessionAuthenticationToken.unauthenticated()
            else -> SessionAuthenticationToken.authenticated(user.username, user.authorities)
        }
}
