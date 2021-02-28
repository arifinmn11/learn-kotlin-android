package com.example.latihanframgent.data.repository

import com.example.latihanframgent.data.model.Item

interface ItemRepositoryInterface {
    fun list(): List<Item>
    fun list(page: Int? = 0): List<Item>
    fun save(item: Item): Item
    fun delete(item: Item): Item
    fun findByItem(item: Item): Item
}
