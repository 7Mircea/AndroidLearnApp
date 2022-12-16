package com.example.myapplication.viewmodels

import android.app.Application
import android.media.MediaPlayer
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.R
import javax.inject.Inject

class MusicViewModel @Inject constructor(val app: Application) : AndroidViewModel(app) {
    private val _mediaPlayer = MutableLiveData<MediaPlayer?>()
    val mediaPlayer: LiveData<MediaPlayer?>
        get() = _mediaPlayer
    private var firstTime = true

    init {
        _mediaPlayer.value = MediaPlayer.create(app.applicationContext, R.raw.waltzno2)
    }

    fun startMusic() {
        Log.i(TAG, "startMusic: ")
        _mediaPlayer.value?.apply {
            if (!firstTime)
                prepare()
            start()
            firstTime = false
        }
    }

    fun stopMusic() {
        _mediaPlayer.value?.stop()
    }

    fun releaseMediaPlayer() {
        _mediaPlayer.value?.release()
        _mediaPlayer.value = null
    }


    companion object {
        const val TAG = "MusicViewModel"
    }
}