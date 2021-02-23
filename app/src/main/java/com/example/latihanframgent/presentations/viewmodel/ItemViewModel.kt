package com.example.latihanframgent.presentations.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.latihanframgent.utils.Item
class ItemViewModel : ViewModel() {

    private val TAG = "ItemViewModel"

    private var ListItem = mutableListOf<Item>();

    fun addItem(item: Item) {
        ListItem.add(item)
    }

    fun getItem(): MutableList<Item> {
        return ListItem
    }
}