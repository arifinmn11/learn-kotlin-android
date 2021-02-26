package com.example.latihanframgent.presentations.itemlist

import com.example.latihanframgent.data.model.Item

interface ItemClickListener {
    fun onDelete(item: Item)
    fun onEdit(item: Item)
    fun onUpdate(item: Item)
}