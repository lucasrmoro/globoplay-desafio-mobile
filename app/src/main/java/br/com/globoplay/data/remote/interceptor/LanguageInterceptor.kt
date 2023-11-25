package br.com.globoplay.data.remote.interceptor

import java.util.Locale
import okhttp3.Interceptor
import okhttp3.Response

class LanguageInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newUrl = request.url.run {
            newBuilder().addQueryParameter(LANGUAGE_QUERY, Locale.getDefault().toLanguageTag())
                .build()
        }
        val newRequest = request.newBuilder().url(newUrl).build()
        return chain.proceed(newRequest)
    }

    companion object {
        private const val LANGUAGE_QUERY = "language"
    }
}