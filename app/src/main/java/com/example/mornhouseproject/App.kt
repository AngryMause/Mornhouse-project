package com.example.mornhouseproject

import android.app.Application
import androidx.room.Room
import com.example.mornhouseproject.network.Repository
import com.example.mornhouseproject.room.FactDataBase

class App : Application() {
    val repository = Repository(this)


}