package com.example.myapplication.network

import com.example.myapplication.model.Monster
import retrofit2.Response
import retrofit2.http.GET

interface MonsterService {
    @GET("/feed/monster_data.json")
    suspend fun getMonsters(): Response<List<Monster>>
}