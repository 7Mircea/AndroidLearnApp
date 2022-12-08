package com.example.myapplication.di.modules

import androidx.lifecycle.ViewModel
import com.example.myapplication.di.annotations.ViewModelKey
import com.example.myapplication.viewmodels.HomeViewModel
import com.example.myapplication.viewmodels.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(value = MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(value = HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}