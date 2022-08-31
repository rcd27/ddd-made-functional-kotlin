package com.github.rcd27

object Streamer

sealed class User {
    object TwitchUser : User()
    object YoutubeUser : User()
    object TrovoUser : User()
}

sealed class Message {
    object TwitchMessage : Message()
    object YoutubeMessage : Message()
    object TrovoMessage : Message()
}


/** Commands */
fun pushMessage(m: Message) {
    when (m) {
        Message.TrovoMessage -> TODO()
        Message.TwitchMessage -> TODO()
        Message.YoutubeMessage -> TODO()
    }
}

fun banUser(u: User) {
    when (u) {
        User.TrovoUser -> TODO()
        User.TwitchUser -> TODO()
        User.YoutubeUser -> TODO()
    }
}
