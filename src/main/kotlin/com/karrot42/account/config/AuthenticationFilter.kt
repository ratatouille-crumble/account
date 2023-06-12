package com.karrot42.account.config

import jakarta.servlet.FilterChain
import jakarta.servlet.annotation.WebFilter
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilterChain
import org.springframework.web.server.session.HeaderWebSessionIdResolver
import reactor.core.publisher.Mono

class AccountAuthenticationFilter(
) : org.springframework.web.server.WebFilter {
    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {

        // exchange 에는 request 정보가 있다
        // println(exchange.request.cookies)
        // println(exchange.request.headers)

        // sessionId에 접근
        val sessionIdResolver = HeaderWebSessionIdResolver()
        // 헤더로 들어온 정보 중에 x-auth-token 정보를 가져온다
        sessionIdResolver.headerName = "x-auth-token"
        val resultSession = sessionIdResolver.resolveSessionIds(exchange)
        println("resultSession :${resultSession}")

        // redis에서 체크


        return chain.filter(exchange)
    }
}