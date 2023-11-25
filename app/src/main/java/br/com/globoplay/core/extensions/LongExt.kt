package br.com.globoplay.core.extensions

fun Long?.orZero() = this ?: Long.ZERO

val Long.Companion.ZERO
    get() = 0L