package com.karrot42.account.repository

import com.karrot42.account.domain.Account
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.cglib.core.Local
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import reactor.core.publisher.Mono
import java.time.LocalDateTime

data class AccountIdResult (
    val id: Long,
    val email: String,
    val activated: Boolean,
    val deletedAt: LocalDateTime?,
)

interface AccountRepository : CoroutineCrudRepository<Account, Long> {
    fun findIdByEmailAndActivatedIsFalseAndDeletedAtIsNull(email: String): Mono<AccountIdResult?>
}

fun AccountRepository.findActiveAccount(email: String) =
    findIdByEmailAndActivatedIsFalseAndDeletedAtIsNull(email)
