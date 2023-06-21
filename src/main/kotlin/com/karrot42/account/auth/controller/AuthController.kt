package com.karrot42.account.auth.controller

import com.karrot42.account.auth.controller.dto.SignupRequest
import com.karrot42.account.auth.service.AuthService
import jakarta.validation.Valid
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.WebSession

@RestController
class AuthController(
   private val authService: AuthService
) {

    @PostMapping("/api/v1/sign-up")
    suspend fun signUp(session: WebSession, @Valid @RequestBody signRequest: SignupRequest): String {
        val accountId = authService.sign(signRequest.toCommand())

        session.attributes["user"] = accountId

        return session.id
    }

    @GetMapping("/api/v1/sign-out")
    suspend fun signOut(session: WebSession): String {
        println(session.getAttribute<Long>("user"))
        session.invalidate().awaitSingleOrNull()

        return "OK"
    }
}
