package com.karrot42.account.auth.controller

import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.WebSession

@RestController
class AuthController {

    @PostMapping("/api/v1/sign-in")
    suspend fun signIn(session: WebSession): String {
        session.attributes["user"] = 123L

        return session.id
    }

    @GetMapping("/api/v1/sign-out")
    suspend fun signOut(session: WebSession): String {
        println(session.getAttribute<Long>("user"))
        session.invalidate().awaitSingleOrNull()

        return "OK"
    }
}
