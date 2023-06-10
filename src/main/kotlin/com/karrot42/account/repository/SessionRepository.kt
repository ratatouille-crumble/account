package com.karrot42.account.repository

import com.karrot42.account.domain.Session
import reactor.core.publisher.Mono

interface SessionRepository {

    fun get(key: String): Mono<Session>
}
