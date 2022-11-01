package com.example.myapplication.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.model.Monster
import com.example.myapplication.utils.Constants.Companion.TABLE_NAME


@Dao
interface MonsterDao {
    @Insert
    suspend fun insert(monster: Monster)

    @Insert
    suspend fun insertAll(monsters: List<Monster>)

    @Query("Select * from $TABLE_NAME")
    fun selectAll(): List<Monster>

    @Delete
    suspend fun delete(monster: Monster)

    @Query("Delete from $TABLE_NAME")
    suspend fun deleteAll()
}