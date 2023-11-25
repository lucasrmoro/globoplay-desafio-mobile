package br.com.globoplay

import android.app.Application
import br.com.globoplay.core.di.AllModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GPlayApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GPlayApplication.applicationContext)
            modules(AllModules.allModules)
        }
    }

}