package com.example.sberbanktest

import android.app.Application
import com.example.sberbanktest.presentation.di.module.mainModule
import com.facebook.drawee.backends.pipeline.Fresco
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        Fresco.initialize(this)

        startKoin {
            androidContext(this@App)
            modules(mainModule)
        }
    }
}