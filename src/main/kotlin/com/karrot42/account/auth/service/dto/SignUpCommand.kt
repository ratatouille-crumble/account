package com.karrot42.account.auth.service.dto

import com.karrot42.account.domain.vo.Email
import com.karrot42.account.domain.vo.Password

data class SignUpCommand(val email: Email, val password: Password)
