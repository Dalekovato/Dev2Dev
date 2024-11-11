package com.example.dev2dev.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class DevApp:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
          androidLogger(Level.NONE)
          androidContext(this@DevApp)
         // modules(appModules)
        }
    }
}