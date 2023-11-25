package br.com.globoplay.core.extensions

fun Int?.orZero() = this ?: Int.ZERO

val Int.Companion.ZERO
    get() = 0