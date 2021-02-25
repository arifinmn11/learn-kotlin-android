package com.example.latihanframgent.presentations.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.latihanframgent.presentations.itemlist.IItemRepository
import com.example.latihanframgent.presentations.itemlist.ItemClickListener
import com.example.latihanframgent.utils.Item
import com.example.latihanframgent.utils.ResourceState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ItemViewModel(val repository: IItemRepository) : ViewModel(), ItemClickListener {
    private var _itemLiveData = MutableLiveData<List<Item>>()
    val itemLiveData: LiveData<List<Item>>
        get() {
            return _itemLiveData
        }

    init {
        loadItemData()
    }

    fun loadItemData() {
        _itemLiveData.value = repository.list()
    }

    fun onAddItem(item: Item) {
        repository.add(item)
        loadItemData()
    }

    override fun onDelete(item: Item) {
        repository.delete(item)
        loadItemData()
    }

}