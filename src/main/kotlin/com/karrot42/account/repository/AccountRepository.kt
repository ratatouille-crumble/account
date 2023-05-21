package com.karrot42.account.repository

import com.karrot42.account.domain.Account
import org.springframework.data.r2dbc.repository.R2dbcRepository

interface AccountRepository : R2dbcRepository<Account, Long>
