package com.example.simple_sprint13_challenge

import android.app.Application
import com.example.simple_sprint13_challenge.di.AppComponent
import com.example.simple_sprint13_challenge.di.DaggerAppComponent


class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .bindApplication(this)
            .build()
    }
}