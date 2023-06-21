package com.karrot42.account.repository

import com.karrot42.account.domain.Account
import com.karrot42.account.domain.vo.Email
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.cglib.core.Local
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import reactor.core.publisher.Mono
import java.time.LocalDateTime

interface AccountRepository : CoroutineCrudRepository<Account, Long> {
    suspend fun existsAccountByEmail(email: String): Boolean
}
