package br.com.globoplay.core.extensions

import br.com.globoplay.core.security.GPlayException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.transform

fun <T> Flow<T>.onError(block: suspend GPlayException.() -> Unit) =
    catch {
        it.printStackTrace()
        block(it.toGPlayException())
    }

suspend fun <T> Flow<T>.onSuccess(block: suspend T.() -> Unit) =
    collect { block(it) }

suspend fun Flow<*>.onFinish(block: () -> Unit) {
    try {
        collect {
            block.invoke()
        }
    } catch (ex: Exception) {
        println(ex)
        block.invoke()
    }
}

fun <T, R> Flow<T>.update(block: suspend T.() -> R): Flow<R> =
    transform { emit(block(it)) }

suspend fun <T> Flow<T>.collectResult(): T? = try {
    var result: T? = null
    collect {
        result = it
    }
    result
} catch (ex: Exception) {
    ex.printStackTrace()
    null
}