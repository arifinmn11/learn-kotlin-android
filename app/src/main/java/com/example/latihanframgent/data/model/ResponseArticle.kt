package com.example.latihanframgent.data.model

data class ResponseArticle(
    val totalResults: Int,
    val articles: List<ArticlesItem>,
    val status: String
)