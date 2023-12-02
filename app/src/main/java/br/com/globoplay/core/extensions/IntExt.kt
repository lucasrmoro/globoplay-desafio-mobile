package br.com.globoplay.core.extensions

fun Int?.orZero() = this ?: Int.ZERO

val Int.Companion.ZERO
    get() = 0

val Int.Companion.FOUR
    get() = 4

val Int.Companion.EIGHT
    get() = 8

val Int.Companion.TWELVE
    get() = 12

val Int.Companion.SIXTEEN
    get() = 16

val Int.Companion.TWENTY
    get() = 20

val Int.Companion.TWENTY_FOUR
    get() = 24

val Int.Companion.TWENTY_EIGHT
    get() = 28

val Int.Companion.THIRTY_TWO
    get() = 32

val Int.Companion.FORTY_EIGHT
    get() = 48

val Int.Companion.NINETY_SIX
    get() = 96

val Int.Companion.ONE_HUNDRED_THIRTY_TWO
    get() = 132