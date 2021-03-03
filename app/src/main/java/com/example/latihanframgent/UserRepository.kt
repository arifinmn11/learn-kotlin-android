package com.example.latihanframgent

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {


    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    fun getUsers(): LiveData<List<User>> {
        return userDao.readAllData()
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }

    fun getUserById(id: Int): LiveData<User> = userDao.getUserById(id)

}