package com.example.latihanframgent

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepositoryImpl) : ViewModel() {

    fun addUser(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.addUser(user)
        }
    }
}
