package com.karrot42.account.config.auth

import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority

class SessionAuthenticationToken private constructor(
    private val principal: String?,
    private val credentials: String?,
    private val authorities: MutableCollection<out GrantedAuthority>,
) : Authentication {

    private var isAuthenticated: Boolean = false

    override fun getName(): String = ""

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> =
        authorities

    override fun getCredentials(): Any =
        credentials ?: ""

    override fun getDetails(): Any = ""

    override fun getPrincipal(): Any =
        principal ?: 0

    override fun isAuthenticated(): Boolean =
        isAuthenticated

    override fun setAuthenticated(isAuthenticated: Boolean) {
        this.isAuthenticated = isAuthenticated
    }

    companion object {

        fun fromCookie(cookie: String): SessionAuthenticationToken {
            return SessionAuthenticationToken(null, cookie, mutableListOf()).apply { isAuthenticated = false }
        }

        fun authenticated(principal: String, authorities: MutableCollection<out GrantedAuthority> = mutableListOf(SimpleGrantedAuthority("ROLE_USER"))): SessionAuthenticationToken {
            return SessionAuthenticationToken(principal, null, authorities).apply { isAuthenticated = true }
        }

        fun unauthenticated(): SessionAuthenticationToken {
            return SessionAuthenticationToken("anonymous", null, mutableListOf(SimpleGrantedAuthority("ROLE_ANONYMOUS"))).apply { isAuthenticated = false }
        }
    }
}
