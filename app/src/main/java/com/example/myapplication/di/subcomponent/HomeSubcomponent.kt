package com.example.myapplication.di.subcomponent

import androidx.lifecycle.ViewModel
import com.example.myapplication.di.annotations.ViewModelKey
import com.example.myapplication.ui.fragments.DetailFragment
import com.example.myapplication.ui.fragments.HomeFragment
import com.example.myapplication.viewmodels.HomeViewModel
import dagger.Binds
import dagger.Subcomponent
import dagger.multibindings.IntoMap

@Subcomponent
interface HomeSubcomponent {

    @Subcomponent.Factory
    interface Factory {
        fun create():HomeSubcomponent
    }



    fun inject(fragment: HomeFragment)
    fun inject(fragment: DetailFragment)
}