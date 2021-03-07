package com.example.latihanframgent.data.api

import com.example.latihanframgent.utils.Constans
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constans.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val itemApi: ItemApi by lazy {
        retrofit.create(ItemApi::class.java)
    }

}