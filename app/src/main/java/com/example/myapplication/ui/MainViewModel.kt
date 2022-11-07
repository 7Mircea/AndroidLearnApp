package com.example.myapplication.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.model.Monster
import com.example.myapplication.repositories.MonsterRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainViewModel @Inject constructor(app: Application,var repository: MonsterRepository) : AndroidViewModel(app) {
    var monsters: MutableLiveData<List<Monster>>
    var selectedMonster = MutableLiveData<Monster>()

    init {
        monsters = repository.monsters
    }
}