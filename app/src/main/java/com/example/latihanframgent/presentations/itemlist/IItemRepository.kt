package com.example.latihanframgent.presentations.itemlist

import com.example.latihanframgent.utils.Item

interface IItemRepository {
    fun add(item: Item)
    fun delete(item: Item)
    fun list(): List<Item>
}