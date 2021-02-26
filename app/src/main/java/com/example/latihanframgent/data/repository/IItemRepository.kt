package com.example.latihanframgent.data.repository

import com.example.latihanframgent.data.model.Item

interface IItemRepository {
    fun add(item: Item)
    fun delete(item: Item)
    fun find(item: Item): Item
    fun finById(id: String): Item
    fun list(): List<Item>
    fun update(item: Item): Item
}