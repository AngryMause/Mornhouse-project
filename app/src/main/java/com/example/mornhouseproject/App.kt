package com.example.mornhouseproject

import android.app.Application
import com.example.mornhouseproject.network.Repository

class App : Application() {
    val repository = Repository()

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: App
            private set
    }

}