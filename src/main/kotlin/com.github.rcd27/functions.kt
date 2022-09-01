package com.github.rcd27

import arrow.core.Either
import arrow.core.right

val plus3: (Int) -> Either<Any, Int> = { (it + 3).right() }
val times2x: (Int) -> Int = { it * 2 }
val square: (Int) -> Int = { it * it }
val addThree = plus3

val toString: (Int) -> String = { "$it опа нихуя" }

fun evalWith5ThenAdd2(f: (Int) -> Int): Int = f(5) + 2

fun adderGenerator(x: Int): (Int) -> Int {
    return {
        it + x
    }
}

fun main() {
    val fList: List<(Int) -> Any> = listOf(plus3, times2x, square, addThree, toString)

    fList.forEach {
        println(it.invoke(6))
    }

    println(
        evalWith5ThenAdd2(square)
    )

    println(
        adderGenerator(4).invoke(6)
    )

}