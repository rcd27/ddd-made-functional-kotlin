package com.github.rcd27

import arrow.core.Either
import arrow.core.left
import arrow.core.right


fun Int.toUnitQuantity(): Either<String, UnitQuantity> {
    return when {
        this < 1 -> "UnitQuantity cannot be less that 1".left()
        this > 1000 -> "UnitQuantity cannot be more than 1000".left()
        else -> this.right()
    }
}