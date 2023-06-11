package com.karrot42.account.config

import org.springframework.context.annotation.Configuration
import org.springframework.session.data.redis.config.annotation.web.server.EnableRedisWebSession


@Configuration
@EnableRedisWebSession
class RedisConfig
