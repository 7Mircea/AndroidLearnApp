package com.example.myapplication.di.modules

import android.content.Context
import com.example.myapplication.database.MonsterDb
import dagger.Module
import dagger.Provides

@Module
abstract class DbModule {
    companion object {
        @Provides
        fun provideDb(context: Context): MonsterDb {
            return MonsterDb.getInstance(context.applicationContext);
        }
    }
}