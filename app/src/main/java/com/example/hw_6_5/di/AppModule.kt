package com.example.hw_6_5.di

import android.content.Context
import android.content.SharedPreferences
import com.example.hw_6_5.data.local.Pref
import com.example.hw_6_5.remote.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    fun provideApi():LoveApi{
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context):SharedPreferences{
        return context.getSharedPreferences(Pref.PREF_KEY, Context.MODE_PRIVATE)
    }

    fun providePref(sharedPreferences: SharedPreferences):Pref{
        return Pref(sharedPreferences)
    }
}