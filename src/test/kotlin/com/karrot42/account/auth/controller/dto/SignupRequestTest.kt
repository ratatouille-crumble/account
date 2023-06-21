package com.karrot42.account.auth.controller.dto

import com.karrot42.account.domain.vo.Email
import com.karrot42.account.domain.vo.Password
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeSameInstanceAs
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SignupRequestTest : FreeSpec ({

    "should convert to SignUpCommand" {
        // given
        val email = "email@abc.com"
        val password = "password"

        // when
        val result = SignupRequest(email, password).toCommand()

        // then
        result.email shouldBe  Email(email)
        result.password shouldBe  Password(password)
    }
})
