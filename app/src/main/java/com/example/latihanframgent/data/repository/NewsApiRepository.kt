package com.example.latihanframgent.data.repository

import com.example.latihanframgent.data.model.ResponseNews
import retrofit2.Response

interface NewsApiRepository {
    suspend fun getNews(keyText: String): Response<ResponseNews>
}