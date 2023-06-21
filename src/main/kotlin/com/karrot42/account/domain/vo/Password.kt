package com.karrot42.account.domain.vo

@JvmInline
value class Password(val value: String) {
    companion object {
        private const val PASSWORD_LENGTH = 6
    }

    init {
        require( value.length > PASSWORD_LENGTH ) { "password should be greater than $PASSWORD_LENGTH"}
    }
}


