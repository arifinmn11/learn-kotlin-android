package com.example.latihanframgent.data.api

import com.example.latihanframgent.data.model.ResponseArticle
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/everything")
    suspend fun getCurrentData(
        @Query("q") keyText: String
    ): Response<ResponseArticle>
}