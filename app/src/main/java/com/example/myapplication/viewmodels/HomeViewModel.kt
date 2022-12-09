package com.example.myapplication.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.model.Monster
import com.example.myapplication.repositories.MonsterRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeViewModel @Inject constructor(app: Application, repository: MonsterRepository) : AndroidViewModel(app) {
    var monsters: MutableLiveData<List<Monster>> = repository.monsters
    var selectedMonster = MutableLiveData<Monster>()
}