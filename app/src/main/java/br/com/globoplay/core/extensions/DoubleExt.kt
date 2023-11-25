package br.com.globoplay.core.extensions

fun Double?.orZero() = this ?: Double.ZERO

val Double.Companion.ZERO
    get() = 0.0