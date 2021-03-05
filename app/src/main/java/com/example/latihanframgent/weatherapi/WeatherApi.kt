package com.example.latihanframgent.weatherapi

import com.example.latihanframgent.data.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("data/2.5/weather?")
    fun getCurrentData(
        @Query("lat") lat: Double,
        @Query("lon") long: Double,
        @Query("APPID") app_id: String
    ): Call<WeatherResponse>
}