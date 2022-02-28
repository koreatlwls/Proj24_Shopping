package com.example.proj24_shopping

import android.app.Application
import com.example.proj24_shopping.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Proj24ShoppingApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@Proj24ShoppingApplication)
            modules(appModule)
        }
    }

}
