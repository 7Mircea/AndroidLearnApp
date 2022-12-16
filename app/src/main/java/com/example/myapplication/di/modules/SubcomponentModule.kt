package com.example.myapplication.di.modules

import com.example.myapplication.di.subcomponent.HomeSubcomponent
import com.example.myapplication.di.subcomponent.MusicSubcomponent
import dagger.Module

@Module(subcomponents = [HomeSubcomponent::class, MusicSubcomponent::class])
abstract class SubcomponentModule