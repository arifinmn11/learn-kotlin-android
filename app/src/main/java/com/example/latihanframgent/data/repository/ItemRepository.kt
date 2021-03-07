package com.example.latihanframgent.data.repository

import com.example.latihanframgent.data.model.Item
import com.example.latihanframgent.data.model.ResponseItem
import com.example.latihanframgent.data.model.ResponseItems

interface ItemRepository {
    suspend fun getItems(): ResponseItems
    suspend fun getItemById(id: Int): ResponseItem
    suspend fun postItem(item: Item): ResponseItem
    suspend fun deleteItemById(id: Int): ResponseItem
}