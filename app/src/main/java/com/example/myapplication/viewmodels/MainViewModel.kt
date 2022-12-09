package com.example.myapplication.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel() {
    val bottomNavState: LiveData<BottomNavState>
        get() = _bottomNavState
    private val _bottomNavState = MutableLiveData<BottomNavState>()

    init {
        _bottomNavState.value = BottomNavState.HOME
    }

    enum class BottomNavState { HOME, CONTACT, MUSIC }


    fun setBottomNavState(pos: BottomNavState) {
        Log.i(TAG, "bottom nav state $pos")
        _bottomNavState.value = pos
    }

    companion object {
        const val TAG = "MainViewModel"
    }
}