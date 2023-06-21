package com.karrot42.account.auth.controller.dto

import com.karrot42.account.auth.service.dto.SignUpCommand
import com.karrot42.account.domain.vo.Email
import com.karrot42.account.domain.vo.Password
import jakarta.validation.constraints.NotBlank

data class SignupRequest(
    @field:NotBlank
    val email: String,

    @field:NotBlank
    val password: String,
) {

    fun toCommand(): SignUpCommand =
        SignUpCommand (
            email = Email(email),
            password = Password(password)
        )
}
