package com.example.myapplication.di.annotations

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Target(AnnotationTarget.PROPERTY_GETTER,AnnotationTarget.PROPERTY_SETTER,AnnotationTarget.FUNCTION)
@Retention(value = AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value:KClass<out ViewModel>)