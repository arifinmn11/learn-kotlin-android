package com.example.latihanframgent.presentations.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.latihanframgent.utils.Item
import com.example.latihanframgent.utils.ResourceState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ItemViewModel : ViewModel() {

    private var ListItem = mutableListOf<Item>();

    fun addItem(item: Item) {
        ListItem.add(item)
    }

    fun getItem(): MutableList<Item> {
        return ListItem
    }

}