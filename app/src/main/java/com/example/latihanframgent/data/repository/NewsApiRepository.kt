package com.example.latihanframgent.data.repository

import com.example.latihanframgent.data.model.ResponseArticle
import retrofit2.Response

interface NewsApiRepository {
    suspend fun getNews(keyText: String, page: Int): Response<ResponseArticle>
}