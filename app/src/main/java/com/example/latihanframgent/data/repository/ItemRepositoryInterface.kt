package com.example.latihanframgent.data.repository

import com.example.latihanframgent.data.model.Item

interface ItemRepositoryInterface {
    fun list(): List<Item>
}
