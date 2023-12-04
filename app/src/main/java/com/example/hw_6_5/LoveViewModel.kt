package com.example.hw_6_5

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw_6_5.remote.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository):ViewModel(){
    fun getLiveLoveData(firstName:String, secondName:String):LiveData<LoveModel>{
        return repository.getData(firstName, secondName)
    }
}