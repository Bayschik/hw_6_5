package com.example.hw_6_5.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hw_6_5.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase:RoomDatabase() {
    abstract fun getDao():LoveDao
}