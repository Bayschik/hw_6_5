package com.example.hw_6_5.data.local

import android.content.SharedPreferences
import javax.inject.Inject

class Pref @Inject constructor(private val pref: SharedPreferences){

    fun isShow():Boolean{
        return pref.getBoolean(SHOWED_KEY, false)
    }

    fun onShowed(){
        pref.edit().putBoolean(SHOWED_KEY, true).apply()
    }

    companion object{
        const val PREF_KEY = "pref.key"
        const val SHOWED_KEY = "showed.key"
    }
}