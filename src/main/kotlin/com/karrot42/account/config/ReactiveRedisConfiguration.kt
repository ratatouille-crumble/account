package com.karrot42.account.config

import com.karrot42.account.domain.Session
import org.springframework.boot.autoconfigure.data.redis.RedisProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory
import org.springframework.data.redis.connection.RedisPassword
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.ReactiveRedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
class ReactiveRedisConfiguration {

    @Bean
    @Primary
    fun reactiveRedisTemplate(reactiveRedisConnectionFactory: ReactiveRedisConnectionFactory): ReactiveRedisTemplate<String, Session> {
        val serializer = Jackson2JsonRedisSerializer(Session::class.java)

        val builder = RedisSerializationContext.newSerializationContext<String, Session>(StringRedisSerializer())

        val context = builder.value(serializer).hashValue(serializer)
            .hashKey(serializer).build()

        return ReactiveRedisTemplate(reactiveRedisConnectionFactory, context)
    }

    @Bean
    @Primary
    fun lettuceConnectionFactory(redisProperties: RedisProperties): ReactiveRedisConnectionFactory =
        LettuceConnectionFactory(
            RedisStandaloneConfiguration(redisProperties.host, redisProperties.port).apply { this.setPassword(RedisPassword.of(redisProperties.password)) },
        )
}
