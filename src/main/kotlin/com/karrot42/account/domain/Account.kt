package com.karrot42.account.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("users")
data class Account(
    @Id
    val id: Long? = null,
    val name: String,
    val nickname: String,
    @Column
    val email: String,
    val profileUri: String,
    val activated: Boolean?,
    val ageAgreement: Boolean,
    val termAgreement: Boolean,
    @CreatedDate
    val createdAt: LocalDateTime,
    @LastModifiedDate
    val updatedAt: LocalDateTime?,
    val deletedAt: LocalDateTime?,
)
