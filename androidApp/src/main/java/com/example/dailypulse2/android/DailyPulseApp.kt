package com.example.dailypulse2.android

import android.app.Application
import com.example.dailypulse2.android.di.viewModelsModule
import com.example.dailypulse2.di.sharedKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DailyPulseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModule + viewModelsModule
        startKoin {
            androidContext(this@DailyPulseApp)
            modules(modules)
        }
    }
}