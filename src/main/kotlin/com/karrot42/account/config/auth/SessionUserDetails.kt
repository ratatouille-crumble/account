package com.karrot42.account.config.auth

import com.karrot42.account.domain.Session
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class SessionUserDetails private constructor(
    private val session: Session,
) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> =
        mutableListOf()

    override fun getPassword(): String = ""
    override fun getUsername(): String = session.id

    override fun isAccountNonExpired(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isAccountNonLocked(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isCredentialsNonExpired(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    companion object {
        fun from(session: Session): SessionUserDetails =
            SessionUserDetails(session)
    }
}
