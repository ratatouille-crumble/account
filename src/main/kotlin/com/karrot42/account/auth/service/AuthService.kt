package com.karrot42.account.auth.service


import com.karrot42.account.auth.service.dto.SignUpCommand
import com.karrot42.account.domain.Account
import com.karrot42.account.domain.vo.Email
import com.karrot42.account.domain.vo.Password
import com.karrot42.account.repository.AccountRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthService(
    private val accountRepository: AccountRepository,
) {

    @Transactional
    suspend fun sign(command:SignUpCommand): Long {
        val isUserExist = accountRepository.existsAccountByEmail(command.email.value)

        check(!isUserExist) { "duplicated email" }

        val account = Account.signUp(command.email, command.password)
        accountRepository.save(account)

        return account.id
    }
}
