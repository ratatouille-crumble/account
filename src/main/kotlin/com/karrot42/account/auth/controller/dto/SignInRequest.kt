package com.karrot42.account.auth.controller.dto

import jakarta.validation.constraints.NotBlank

data class SignInRequest(
    @field:NotBlank
    val email: String,

    @field:NotBlank
    val password: String,
)
