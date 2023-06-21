package com.karrot42.account.domain.vo

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException


internal class EmailTest: FreeSpec({

    "should create email" {
        // given
        val email = "user@domain.com"


        // when
        val result = Email(email)

        // then
        result.value shouldBe email
    }

    "should throw error if email is invalid" {
        // given
        val email = "123456789"

        // when & then
        shouldThrow<IllegalArgumentException> {
            Email(email)
        }
    }

})
