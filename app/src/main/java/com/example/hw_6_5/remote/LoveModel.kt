package com.example.hw_6_5.remote

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("love-table")
data class LoveModel(
    val fname:String,
    val sname:String,
    val percentage:String,
    val result:String,
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
){
    override fun toString(): String {
        return super.toString()
        return "\n$percentage \n$fname \n$sname \n$result\n"
    }
}
