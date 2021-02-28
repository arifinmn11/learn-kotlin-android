package com.example.latihanframgent.form

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.latihanframgent.data.model.Item
import com.example.latihanframgent.data.repository.ItemRepository

class FormViewModel(val repository: ItemRepository) : ViewModel() {
    private var _itemLiveData = MutableLiveData<Item>()

    val itemLiveData: LiveData<Item>
        get() {
            return _itemLiveData
        }

    fun save(item: Item) {
        _itemLiveData.value = repository.save(item)
    }

    fun validation(item: Item) {

    }
}