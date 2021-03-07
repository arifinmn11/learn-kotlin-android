package com.example.latihanframgent.data.api

import com.example.latihanframgent.data.model.Item
import com.example.latihanframgent.data.model.ResponseItem
import com.example.latihanframgent.data.model.ResponseItems
import retrofit2.http.*

interface ItemApi {
    @GET("/item/{id}/get")
    suspend fun getItemBydId(
        @Path("id") id: Int
    ): ResponseItem

    @GET("/items")
    suspend fun getItems(): ResponseItems

    @POST("/item")
    suspend fun postItem(
        @Body item: Item
    ): ResponseItem

    @DELETE("/item/{id}")
    suspend fun deleteItemById(
        @Path("id") id: Int
    ): ResponseItem
}