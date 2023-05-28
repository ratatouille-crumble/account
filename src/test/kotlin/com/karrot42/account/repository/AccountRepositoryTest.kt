package com.karrot42.account.repository

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.r2dbc.spi.ConnectionFactory
import javax.sql.DataSource
import org.flywaydb.core.Flyway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest
import org.springframework.r2dbc.core.DatabaseClient

//@DataR2dbcTest
//internal class AccountRepositoryTest @Autowired constructor(
//    val connectionFactory: ConnectionFactory,
//    val databaseClient: DatabaseClient,
//    val accountRepository: AccountRepository
//) : FreeSpec({
//    "String.length" - {
//        "should return the length of the string" {
//            "sammy".length shouldBe 5
//            "".length shouldBe 0
//        }
//    }
//
//    "containers can be nested as deep as you want" - {
//        "and so we nest another container" - {
//            "yet another container" - {
//                "finally a real test" {
//                    1 + 1 shouldBe 2
//                }
//            }
//        }
//    }
//})

@DataR2dbcTest
class PostRepositoryTest @Autowired constructor(
    val connectionFactory: ConnectionFactory,
    val databaseClient: DatabaseClient,
    val accountRepository: AccountRepository,
) : FreeSpec({
    beforeEach {
//        flyway.clean()
//        flyway.migrate()
    }
"String.length" - {
    "should return the length of the string" {
        databaseClient
        connectionFactory
        val a = accountRepository.count().block()
        "sammy".length shouldBe 5
        "".length shouldBe 0
    }
}

"containers can be nested as deep as you want" - {
    "and so we nest another container" - {
        "yet another container" - {
            "finally a real test" {
                accountRepository.count() shouldBe 0
            }
        }
    }
}})
