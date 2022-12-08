package com.example.myapplication.repositories

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.database.MonsterDb
import com.example.myapplication.model.Monster
import com.example.myapplication.network.MonsterService
import com.example.myapplication.utils.Constants.Companion.FILE_NAMES
import com.example.myapplication.utils.Constants.Companion.WEB_SERVICE_URL
import com.example.myapplication.utils.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

const val TAG = "MonsterRepository"

class MonsterRepository @Inject constructor(private var context: Context,var db:MonsterDb) {
    var monsters: MutableLiveData<List<Monster>> = MutableLiveData()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            val list: List<Monster> = if (isConnectedOrConnectingToInternet()) {
                getMonstersFromInternet()
            } else
                getMonstersFromDb()
//            for (monster in list)
//                Log.i(TAG, "monsters: $monster")
            monsters.postValue(list)
        }
    }

    @WorkerThread
    private suspend fun getMonstersFromInternet(): List<Monster> {
        if (isConnectedOrConnectingToInternet()) {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(WEB_SERVICE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
            val service = retrofit.create(MonsterService::class.java)
            val data = service.getMonsters().body() ?: emptyList()
            db.monsterDao().deleteAll()
            db.monsterDao().insertAll(data)
            return data
        }
        return emptyList()
    }

    @WorkerThread
    private suspend fun getMonstersFromDb(): List<Monster> {
        return db.monsterDao().selectAll()
    }

    @WorkerThread
    private suspend fun getMonstersFromFile(): List<Monster> {
        val names: List<String> = Utils.readFile(context, FILE_NAMES)
        val monster: MutableList<Monster> = mutableListOf()
        for (name in names) {
            monster.add(Monster(1, name, "", "", "", 0.0, 0))
        }
        return monster
    }

    private suspend fun isConnectedOrConnectingToInternet(): Boolean {
        val connectionManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectionManager.isDefaultNetworkActive
    }

}