package com.karrot42.account.domain

import com.karrot42.account.domain.vo.Email
import com.karrot42.account.domain.vo.Password
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table
data class Account private constructor(
    @Id
    val id: Long = 0,
    @Column("email")
    private val _email: String,
    @Column("password")
    private val _password: String,
    val deletedAt: LocalDateTime? = null,
    @CreatedDate
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @LastModifiedDate
    val updatedAt: LocalDateTime = LocalDateTime.now(),
) {
    companion object {
        fun signUp(email: Email, password: Password): Account{
            return Account(
                _email = email.value,
                _password = password.value,
            )
        }
    }

    val email: Email
        get() = Email(_email)

    val password: Password
        get() = Password(_password)

}
