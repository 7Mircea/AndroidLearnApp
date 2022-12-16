package com.example.myapplication.di

import android.app.Application
import android.content.Context
import com.example.myapplication.di.modules.DbModule
import com.example.myapplication.di.modules.SubcomponentModule
import com.example.myapplication.di.modules.ViewModelsModule
import com.example.myapplication.di.subcomponent.HomeSubcomponent
import com.example.myapplication.di.subcomponent.MusicSubcomponent
import com.example.myapplication.ui.activities.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DbModule::class, SubcomponentModule::class, ViewModelsModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context, @BindsInstance app: Application): AppComponent
    }

    fun inject(activity: MainActivity)

    fun homeSubcomponent(): HomeSubcomponent.Factory
    fun musicSubcomponent(): MusicSubcomponent.Factory
}