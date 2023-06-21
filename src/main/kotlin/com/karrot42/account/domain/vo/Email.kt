package com.karrot42.account.domain.vo

@JvmInline
value class Email(val value: String) {
    companion object {
        private const val EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    }

    init {
        require(value.matches(Regex(EMAIL_REGEX))) { "Invalid email address" }
    }
}
