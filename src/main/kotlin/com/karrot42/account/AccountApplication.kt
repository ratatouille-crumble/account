package com.karrot42.account

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
class AccountApplication

fun main(args: Array<String>) {
	runApplication<AccountApplication>(*args)
}
