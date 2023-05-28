package com.karrot42.account.repository

import com.karrot42.account.domain.Account
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface AccountRepository : ReactiveCrudRepository<Account, Long>
