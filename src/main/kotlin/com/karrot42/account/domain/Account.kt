package com.karrot42.account.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("users")
data class Account(
    @Id
    val id: Long = 0,
    val name: String,
    val nickname: String,
    val email: String,
    val profileUri: String,
    private val activated: Byte = 0,
    private val ageAgreement: Byte = 0,
    private val termAgreement: Byte = 0,
    val deletedAt: LocalDateTime? = null,
    @CreatedDate
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @LastModifiedDate
    val updatedAt: LocalDateTime = LocalDateTime.now(),
) {
    val isActivated: Boolean
        get() = activated == 1.toByte()

    val isAgeAgreement: Boolean
        get() = ageAgreement == 1.toByte()

    val isTermAgreement: Boolean
        get() = termAgreement == 1.toByte()

    companion object {
        fun of(
            name: String,
            nickname: String,
            email: String,
            profileUri: String,
            ageAgreement: Boolean,
            termAgreement: Boolean,
        ) = Account(
            name = name,
            nickname = nickname,
            email = email,
            profileUri = profileUri,
            ageAgreement = if (ageAgreement) 1 else 0,
            termAgreement = if (termAgreement) 1 else 0,
        )
    }
}
