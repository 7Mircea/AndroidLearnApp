package com.example.myapplication.di.modules

import androidx.lifecycle.ViewModel
import com.example.myapplication.di.annotations.ViewModelKey
import com.example.myapplication.ui.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel):ViewModel
}