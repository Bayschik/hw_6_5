package com.example.hw_6_5.remote

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun getLove(
        @Query("sname") secondName:String,
        @Query("fname") firstName:String,
        @Header("X-RapidAPI-Key") key:String = "62046210eamshb1039cc3a834d5ep160059jsn329f9fbbe521",
        @Header("X-RapidAPI-Host") host:String = "love-calculator.p.rapidapi.com"
    ):retrofit2.Call<LoveModel>
}