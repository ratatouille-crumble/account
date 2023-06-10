package com.karrot42.account.config.auth

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AnonymousUserDetail private constructor() : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority?> =
        mutableListOf(SimpleGrantedAuthority("ROLE_ANONYMOUS"))

    override fun getPassword(): String? = null

    override fun getUsername(): String = "anonymous"

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = false

    companion object {
        val INSTANCE = AnonymousUserDetail()
    }
}
