package com.example.latihanframgent

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepositoryImpl) : ViewModel() {
    private var _ListData = MutableLiveData<List<User>>()

    val ListData: LiveData<List<User>>
        get() {
            getUser()
            return _ListData
        }

    fun addUser(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.addUser(user)
        }
    }

    fun getUser() {
        _ListData.postValue(repository.getUsers())
        Log.d("GET USER : ", "${repository.getUsers()}")
    }
}
