package com.example.latihanframgent.presentations.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.latihanframgent.data.repository.IItemRepository
import com.example.latihanframgent.presentations.itemlist.ItemClickListener
import com.example.latihanframgent.data.model.Item

class ItemViewModel(private val repository: IItemRepository) : ViewModel(), ItemClickListener {
    private var _itemLiveData = MutableLiveData<List<Item>>()
    private var _item = MutableLiveData<Item>()

    val itemsLiveData: LiveData<List<Item>>
        get() {
            return _itemLiveData
        }

    val itemLiveData: LiveData<Item>
        get() {
            return _item
        }


    init {
        loadItemData()
    }

    private fun loadItemData() {
        _itemLiveData.value = repository.list()
    }

    private fun findItemData(item: Item) {
        _item.value = repository.find(item)
    }

    private fun findItemById(id: String) {
        _item.value = repository.finById(id)
    }

    fun onAddItem(item: Item) {
        repository.add(item)
        loadItemData()
    }

    override fun onDelete(item: Item) {
        repository.delete(item)
        loadItemData()
    }

    override fun onEdit(item: Item) {
        findItemData(item)
    }


    override fun onUpdate(data: Item) {
        val item = findItemById(data.id)
        repository.update(data)
    }


}