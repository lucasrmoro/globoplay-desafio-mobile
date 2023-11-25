package br.com.globoplay.core.extensions

import br.com.globoplay.core.security.GPlayException
import com.google.gson.Gson
import retrofit2.HttpException

fun Throwable?.toGPlayException(): GPlayException = when (this) {
    is HttpException -> try {
        Gson().fromJson(
            response()?.errorBody()?.string().orEmpty(),
            GPlayException::class.java
        )
    } catch (ex: Exception) {
        GPlayException(statusCode = null, message = ex.message)
    }

    else -> GPlayException(statusCode = null, message = null)
}