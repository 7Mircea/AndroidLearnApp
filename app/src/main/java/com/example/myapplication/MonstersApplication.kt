package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.DaggerAppComponent

class MonstersApplication: Application() {
    val appComponent by lazy {
        DaggerAppComponent.factory().create(this.applicationContext, this)
    }
}