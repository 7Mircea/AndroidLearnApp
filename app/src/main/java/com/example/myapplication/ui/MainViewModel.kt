package com.example.myapplication.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.model.Monster
import com.example.myapplication.repositories.MonsterRepository

class MainViewModel(app: Application) : AndroidViewModel(app) {
    var monsters: MutableLiveData<List<Monster>>
    var selectedMonster = MutableLiveData<Monster>()
    private var repository: MonsterRepository = MonsterRepository(app)
    init {
        monsters = repository.monsters
    }
}