package com.example.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.model.Monster
import com.example.myapplication.utils.Constants.Companion.DB_NAME

@Database(entities = [Monster::class], version = 1, exportSchema = false)
abstract class MonsterDb : RoomDatabase() {
    abstract fun monsterDao(): MonsterDao

    companion object {
        @Volatile
        private var INSTANCE: MonsterDb? = null

        fun getInstance(context: Context):MonsterDb {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(context,MonsterDb::class.java,DB_NAME)
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}