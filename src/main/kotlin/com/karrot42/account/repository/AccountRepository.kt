package com.karrot42.account.repository

import com.karrot42.account.domain.Account
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface AccountRepository : CoroutineCrudRepository<Account, Long>
