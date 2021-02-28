package com.example.latihanframgent.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.latihanframgent.data.model.Item
import com.example.latihanframgent.data.repository.ItemRepositoryInterface
import com.example.latihanframgent.listeners.ItemClickListener

class ListViewModel(private val repository: ItemRepositoryInterface) : ViewModel(),
    ItemClickListener {

    private var _itemsLiveData = MutableLiveData<List<Item>>()

    val itemsLiveData: LiveData<List<Item>>
        get() {
            loadItemData()
            return _itemsLiveData
        }

    fun loadItemData() {
        _itemsLiveData.value = repository.list()
    }

    override fun onDelete(item: Item) {
        repository.delete(item)
        loadItemData()
    }

}