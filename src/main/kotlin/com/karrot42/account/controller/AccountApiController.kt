package com.karrot42.account.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountApiController {

    @GetMapping("/")
    fun hello(): String = "Hello, world!"

    @GetMapping("/profile")
    fun profile(): String = "Hello, world!"
}
