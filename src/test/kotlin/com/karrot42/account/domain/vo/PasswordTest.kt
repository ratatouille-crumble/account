package com.karrot42.account.domain.vo

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PasswordTest: FreeSpec ({

    "should create password" {
        // given
        val password = "123456789"

        // when
        val result = Password(password)

        // then
        result.value shouldBe password
    }
})
