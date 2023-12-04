package com.example.hw_6_5.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.hw_6_5.remote.LoveModel

@Dao
interface LoveDao {
    @Insert
    fun insert(loveModel:LoveModel)

    @Query("SELECT * FROM `love-table` ORDER BY fname ASC")
    fun getAll():List<LoveModel>
}