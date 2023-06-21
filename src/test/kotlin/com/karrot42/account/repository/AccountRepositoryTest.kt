package com.karrot42.account.repository

import com.karrot42.account.config.SchemaInitConfig
import com.karrot42.account.domain.Account
import com.karrot42.account.domain.vo.Email
import com.karrot42.account.domain.vo.Password
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.longs.shouldBeGreaterThan
import io.kotest.matchers.nulls.shouldNotBeNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest
import org.springframework.context.annotation.Import

@DataR2dbcTest
@Import(SchemaInitConfig::class)
internal class AccountRepositoryTest @Autowired constructor(
    private val accountRepository: AccountRepository,
) : FreeSpec({

    beforeEach {
        accountRepository.deleteAll()
    }

    "should create account" {
        // given
        val account = Account.signUp(
            email = Email("test@email.com"),
            password = Password("password"),
        )
        val created = accountRepository.save(account)

        // when
        val result = accountRepository.findById(created.id)

        // then
        result.shouldNotBeNull()
        result.id shouldBeGreaterThan 0
    }
})
