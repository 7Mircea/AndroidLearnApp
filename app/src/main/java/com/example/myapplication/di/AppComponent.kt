package com.example.myapplication.di

import android.app.Activity
import android.app.Application
import android.content.Context
import com.example.myapplication.di.modules.DbModule
import com.example.myapplication.ui.DetailFragment
import com.example.myapplication.ui.MainActivity
import com.example.myapplication.ui.MainFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DbModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context, @BindsInstance app:Application):AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: DetailFragment)
    fun inject(fragment: MainFragment)
}