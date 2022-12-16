package com.example.myapplication.di.subcomponent

import com.example.myapplication.ui.fragments.music.MusicFragment
import dagger.Subcomponent
@Subcomponent
interface MusicSubcomponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MusicSubcomponent
    }

    fun inject(fragment: MusicFragment)
}