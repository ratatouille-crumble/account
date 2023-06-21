package com.karrot42.account.auth.service

import com.google.api.client.json.webtoken.JsonWebSignature
import com.google.auth.oauth2.TokenVerifier
import com.karrot42.account.repository.AccountRepository
import com.karrot42.account.repository.findActiveAccount
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val accountRepository: AccountRepository,
) {

    suspend fun signIn(idToken: String){
        // google
        val result: JsonWebSignature = TokenVerifier.newBuilder().build().verify(idToken)
        val user = accountRepository.findActiveAccount(result.payload["email"] as String).awaitSingle()

        println(user)
    }
}
