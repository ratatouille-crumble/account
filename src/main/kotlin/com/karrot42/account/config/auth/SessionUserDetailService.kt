package com.karrot42.account.config.auth

import com.karrot42.account.repository.SessionRepository
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class SessionUserDetailService(private val sessionRepository: SessionRepository) : ReactiveUserDetailsService {

    override fun findByUsername(username: String): Mono<UserDetails> =
        sessionRepository.get(username).map { SessionUserDetails.from(it) }
}
