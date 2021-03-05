package com.example.latihanframgent.data.repository

import com.example.latihanframgent.data.api.RetrofitInstance
import com.example.latihanframgent.data.model.ResponseNews
import retrofit2.Response

class NewsApiRepositoryImpl : NewsApiRepository {
    override suspend fun getNews(keyText: String): Response<ResponseNews> =
        RetrofitInstance.getNewsApiService().getCurrentData(keyText)
}