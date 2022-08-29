package com.github.rcd27

import arrow.core.Ior
import arrow.core.leftIor
import arrow.core.rightIor

interface ContactInfo {
    val contactInfo: String

    companion object {
        val identity: ContactInfo = object : ContactInfo {
            override val contactInfo: String
                get() = ""
        }
    }
}

data class EmailContactInfo(val email: String) : ContactInfo {
    override val contactInfo: String
        get() = email
}

data class AddressContactInfo(val address: String) : ContactInfo {
    override val contactInfo: String
        get() = address

}

data class Contact(val name: String, val contactInfo: Ior<EmailContactInfo, AddressContactInfo>)

fun main() {
    val contactWithMail = Contact("Charlie Sheen", EmailContactInfo("charlie@mail.com").leftIor())
    val contactWithAddress = Contact("Miamoto Musassi", AddressContactInfo("Tokyo").rightIor())

    val result = listOf(contactWithAddress, contactWithMail).filter { it.contactInfo.isRight }

    result.forEach {
        println(it.contactInfo)
    }
}