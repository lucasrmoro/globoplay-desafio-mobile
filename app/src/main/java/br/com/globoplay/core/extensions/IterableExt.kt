package br.com.globoplay.core.extensions

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

suspend fun <T, R> Iterable<T>.concurrentMap(block: suspend (T) -> R): List<R> = coroutineScope {
    map { async { block(it) } }.awaitAll()
}