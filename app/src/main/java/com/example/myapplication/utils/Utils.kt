package com.example.myapplication.utils

import android.content.Context

class Utils {
    companion object {
        fun readFile(context: Context,fileName:String):List<String> {
            val names = context.assets.open(fileName).use {
                it.bufferedReader().use {reader ->
                    reader.readText()
                }
            }
            return names.split("\n")
        }
    }

}