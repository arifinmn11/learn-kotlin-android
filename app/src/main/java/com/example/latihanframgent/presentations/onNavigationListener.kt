package com.example.latihanframgent.presentations

import com.example.latihanframgent.utils.Item

interface OnNavigationListener {
    fun menuItem()
    fun showItems()
    fun addItem(item: Item)
}