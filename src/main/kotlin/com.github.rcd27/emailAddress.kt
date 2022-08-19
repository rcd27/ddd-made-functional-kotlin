package com.github.rcd27

import arrow.core.Either

interface EmailAddress {
    val value: String
}

interface VerifiedEmailAddress : EmailAddress {
    override val value: String
}

interface UnverifiedEmailAddress : EmailAddress {
    override val value: String
}


sealed class CustomerEmail : EmailAddress {
    data class Unverified(override val value: String) : UnverifiedEmailAddress
    data class Verified(override val value: String) : VerifiedEmailAddress
}

val verifyEmailAddress: (UnverifiedEmailAddress) -> Either<Throwable, VerifiedEmailAddress> = {
    TODO("some code here")
}

val sendPasswordResetEmail: (VerifiedEmailAddress) -> Unit = {
    TODO("some code here, accepts only")
}

fun main() {
    val notThatTypeMail = CustomerEmail.Unverified("this@dot.com")
    // sendPasswordResetEmail.invoke(notThatTypeMail) COMPILATION error, suddenly
}