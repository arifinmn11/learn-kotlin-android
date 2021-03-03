package com.example.latihanframgent

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {
    fun addUser(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.addUser(user)
        }
    }

    fun getUsers(): LiveData<List<User>> = repository.getUsers()

    fun getUserById(id: Int): LiveData<User> = repository.getUserById(id)

    fun updateUser(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.updateUser(user)
        }
    }

    fun deleteUser(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.deleteUser(user)
        }
    }

}
