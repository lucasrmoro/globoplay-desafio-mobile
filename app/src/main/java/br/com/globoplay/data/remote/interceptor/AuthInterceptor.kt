package br.com.globoplay.data.remote.interceptor

import br.com.globoplay.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request()
            .newBuilder()
            .addHeader(
                AUTHORIZATION_HEADER,
                "Bearer ${BuildConfig.THE_MOVIE_DB_API_KEY}"
            )
            .build()

        return chain.proceed(newRequest)
    }

    companion object {
        private const val AUTHORIZATION_HEADER = "Authorization"
    }
}