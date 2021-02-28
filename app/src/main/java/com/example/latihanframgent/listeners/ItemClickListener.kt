package com.example.latihanframgent.listeners

import com.example.latihanframgent.data.model.Item

interface ItemClickListener {
    fun onDelete(item: Item)
    fun onEdit(item: Item)
}