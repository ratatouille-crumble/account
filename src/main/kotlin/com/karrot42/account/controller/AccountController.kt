package com.karrot42.account.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.server.WebSession
import reactor.core.publisher.Mono


@Controller
class AccountController {

    @GetMapping("/public")
    fun index(): String {
        return "login"
    }

    @GetMapping("/public/session")
    fun getSession(session: WebSession): String {
        session.attributes.putIfAbsent("note", "Howdy Cosmic Spheroid!")
        println("~~~~~~~~~~ ${session.attributes}")
//        return Mono.just(session.attributes["note"] as String?)
        return "string"
    }
}