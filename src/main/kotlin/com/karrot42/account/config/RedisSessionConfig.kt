package com.karrot42.account.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.session.data.redis.config.annotation.web.server.EnableRedisWebSession
import org.springframework.web.server.session.HeaderWebSessionIdResolver
import org.springframework.web.server.session.WebSessionIdResolver


@Configuration
@EnableRedisWebSession
class RedisSessionConfig {
    @Bean
    fun webSessionIdResolver(): WebSessionIdResolver = HeaderWebSessionIdResolver().apply {
        headerName = "X-AUTH-TOKEN"
    }
}
