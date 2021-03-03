package com.example.latihanframgent

class UserRepositoryImpl(private val userDao: UserDao) {


    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    fun getUsers(): List<User> {
       return userDao.readAllData()
    }

}