package com.karrot42.account.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class AccountController {

    @GetMapping("/login")
    fun index(): String {
        return "login"
    }
}