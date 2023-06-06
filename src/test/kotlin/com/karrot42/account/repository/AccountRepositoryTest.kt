package com.karrot42.account.repository

import com.karrot42.account.config.SchemaInitConfig
import com.karrot42.account.domain.Account
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.longs.shouldBeGreaterThan
import io.kotest.matchers.nulls.shouldNotBeNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest
import org.springframework.context.annotation.Import

@DataR2dbcTest
@Import(SchemaInitConfig::class)
internal class AccountRepositoryTest @Autowired constructor(
    private val accountRepository: AccountRepository
) : FreeSpec({

    beforeEach {
        accountRepository.deleteAll()
    }

    "should create account" {
        val account = Account.of(
            name = "name",
            nickname = "nickname",
            email = "email",
            profileUri = "profileUri",
            ageAgreement = true,
            termAgreement = true,
        )
        val created = accountRepository.save(account)

        val result = accountRepository.findById(created.id)

        result.shouldNotBeNull()
        result.id shouldBeGreaterThan 0
    }
})

