package com.karrot42.account.domain

import org.springframework.data.redis.core.RedisHash

@RedisHash("session")
data class Session(
    val id: String,
    val username: String,
    val email: String,
    val roles: List<String>,
)
