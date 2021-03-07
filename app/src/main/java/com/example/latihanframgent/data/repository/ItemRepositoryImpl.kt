package com.example.latihanframgent.data.repository

import com.example.latihanframgent.data.api.RetrofitInstance
import com.example.latihanframgent.data.model.Item
import com.example.latihanframgent.data.model.ResponseItem
import com.example.latihanframgent.data.model.ResponseItems

class ItemRepositoryImpl : ItemRepository {
    override suspend fun getItems(): ResponseItems = RetrofitInstance.itemApi.getItems()
    override suspend fun getItemById(id: Int): ResponseItem  = RetrofitInstance.itemApi.getItemBydId(id)
    override suspend fun postItem(item: Item): ResponseItem = RetrofitInstance.itemApi.postItem(item)
    override suspend fun deleteItemById(id: Int): ResponseItem = RetrofitInstance.itemApi.deleteItemById(id)
}