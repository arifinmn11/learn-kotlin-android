package com.example.latihanframgent.list

import android.util.Log
import androidx.lifecycle.*
import com.example.latihanframgent.data.model.Item
import com.example.latihanframgent.data.model.ResponseItem
import com.example.latihanframgent.data.model.ResponseItems
import com.example.latihanframgent.data.repository.ItemRepository
import com.example.latihanframgent.listeners.ItemClickListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withTimeout

class ListViewModel(val repository: ItemRepository) : ViewModel(), ItemClickListener {
    private val _deleteLiveButton = MutableLiveData<Int>()
    val deleteLiveButton: LiveData<Int>
        get() {
            return _deleteLiveButton
        }

    fun getItemList() = liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
        withTimeout(5000) {
            var response: ResponseItems? = null
            try {
                emit(response)
                response = repository.getItems()
            } catch (e: Exception) {
                response =
                    ResponseItems(status = 400, message = "Error, try again", data = arrayListOf())
                emit(response)
            } finally {
                emit(response)
            }
        }
    }

    fun deleteItem(id: Int) = liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
        withTimeout(5000) {
            var response: ResponseItem? = null
            try {
                emit(response)
                response = repository.deleteItemById(id)
            } catch (e: Exception) {
                response = ResponseItem(status = 400, message = "Error, try again", data = null)
                emit(response)
            } finally {
                emit(response)
                Log.d("REQUEST", "REQUEST")
            }
        }
    }

    override fun onDelete(item: Item) {
        _deleteLiveButton.postValue(item.id)
    }

    override fun onEdit(item: Item) {
        TODO("Not yet implemented")
    }

}