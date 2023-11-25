package br.com.globoplay.core.di

import br.com.globoplay.BuildConfig
import br.com.globoplay.core.base.BaseDIModule
import br.com.globoplay.data.remote.interceptor.AuthInterceptor
import br.com.globoplay.data.remote.interceptor.LanguageInterceptor
import java.util.concurrent.TimeUnit.SECONDS
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule : BaseDIModule {

    override val module: Module = module {
        single<Converter.Factory> { GsonConverterFactory.create() }
        single<Interceptor>(named(LOGGING_INTERCEPTOR)) {
            HttpLoggingInterceptor().setLevel(
                if (BuildConfig.DEBUG) Level.BODY else Level.NONE
            )
        }
        single<Interceptor>(named(AUTH_INTERCEPTOR)) { AuthInterceptor() }
        single<Interceptor>(named(LANGUAGE_INTERCEPTOR)) { LanguageInterceptor() }
        single {
            OkHttpClient.Builder()
                .connectTimeout(TIMEOUT_TIME_IN_SECONDS, SECONDS)
                .writeTimeout(TIMEOUT_TIME_IN_SECONDS, SECONDS)
                .readTimeout(TIMEOUT_TIME_IN_SECONDS, SECONDS)
                .addInterceptor(get<Interceptor>(named(LOGGING_INTERCEPTOR)))
                .addInterceptor(get<Interceptor>(named(AUTH_INTERCEPTOR)))
                .addInterceptor(get<Interceptor>(named(LANGUAGE_INTERCEPTOR)))
                .build()
        }
        single {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(get())
                .client(get())
                .build()
        }
    }

    private const val BASE_URL = "https://api.themoviedb.org/3/"
    private const val TIMEOUT_TIME_IN_SECONDS = 20L
    private const val LOGGING_INTERCEPTOR = "LOGGING_INTERCEPTOR"
    private const val AUTH_INTERCEPTOR = "AUTH_INTERCEPTOR"
    private const val LANGUAGE_INTERCEPTOR = "LANGUAGE_INTERCEPTOR"
}