package com.karrot42.account.auth.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.WebSession

@RestController
@RequestMapping("/auth")
class AuthController {

    @GetMapping("/signin")
    fun signin(session: WebSession): String {
        // email, password 같은걸 request 로 받아서 유저 존재여부 체크해 유저 아이디 설정
        session.attributes["userId"] = 1234L

        return session.id;
    }

    @GetMapping("/other-api")
    fun other(): String = "other-api"

}
