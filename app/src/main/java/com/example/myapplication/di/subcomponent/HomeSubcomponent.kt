package com.example.myapplication.di.subcomponent

import com.example.myapplication.ui.fragments.home.DetailFragment
import com.example.myapplication.ui.fragments.home.HomeFragment
import dagger.Subcomponent

@Subcomponent
interface HomeSubcomponent {

    @Subcomponent.Factory
    interface Factory {
        fun create():HomeSubcomponent
    }



    fun inject(fragment: HomeFragment)
    fun inject(fragment: DetailFragment)
}