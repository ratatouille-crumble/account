package com.karrot42.account.config.auth

import com.karrot42.account.domain.Session
import com.karrot42.account.repository.SessionRepository
import org.springframework.data.redis.core.ReactiveRedisOperations
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
class RedisSessionRepository(private val redisOperations: ReactiveRedisOperations<String, Session>) : SessionRepository {

    override fun get(key: String): Mono<Session> =
        redisOperations.opsForValue().get(key)
}
