package com.example.latihanframgent.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.latihanframgent.data.model.Item
import com.example.latihanframgent.data.repository.ItemRepository
import com.example.latihanframgent.data.repository.ItemRepositoryInterface
import com.example.latihanframgent.listeners.ItemClickListener

class ListViewModel(private val repository: ItemRepository) : ViewModel(),
    ItemClickListener {

    private var _itemsLiveData = MutableLiveData<List<Item>>()
    private var _itemLiveData = MutableLiveData<Item>()

    val itemsLiveData: LiveData<List<Item>>
        get() {
            return _itemsLiveData
        }

    val itemLiveData: LiveData<Item>
        get() {
            return _itemLiveData
        }

    init {
        loadItemData(0)
    }

    fun loadItemData() {
        _itemsLiveData.value = repository.list(0)
    }

    fun getItemData(item: Item) {
        _itemLiveData.value = repository.findById(item)
    }

    fun loadItemData(page: Int) {
        _itemsLiveData.value = repository.list(page)
    }

    override fun onDelete(item: Item) {
        repository.delete(item)
        loadItemData()
    }

    override fun onEdit(item: Item) {
        getItemData(item)
    }

}