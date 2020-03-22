package com.tobibur.covid_19

import android.app.Application
import com.tobibur.covid_19.di.dataModule
import com.tobibur.covid_19.di.networkModule
import com.tobibur.covid_19.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application(){


    override fun onCreate() {
        super.onCreate()

        initializeKoin()
    }

    private fun initializeKoin() {
        startKoin {
            androidContext(this@MyApplication)
            modules(
                listOf(
                    networkModule,
                    dataModule,
                    viewModelModule
                )
            )
        }
    }
}