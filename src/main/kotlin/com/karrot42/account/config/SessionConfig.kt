package com.karrot42.account.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.session.data.redis.config.annotation.web.server.EnableRedisWebSession
import org.springframework.web.server.session.HeaderWebSessionIdResolver
import org.springframework.web.server.session.WebSessionIdResolver

@EnableRedisWebSession
@Configuration
class SessionConfig {

    @Bean
    fun webSessionIdResolver(): WebSessionIdResolver {
        val sessionIdResolver = HeaderWebSessionIdResolver()
        sessionIdResolver.headerName = "X-AUTH-TOKEN"
        return sessionIdResolver
    }
}
