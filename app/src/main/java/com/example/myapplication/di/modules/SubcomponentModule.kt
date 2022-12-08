package com.example.myapplication.di.modules

import com.example.myapplication.di.subcomponent.HomeSubcomponent
import dagger.Module

@Module(subcomponents = [HomeSubcomponent::class])
abstract class SubcomponentModule