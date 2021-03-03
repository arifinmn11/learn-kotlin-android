package com.example.latihanframgent

class UserRepositoryImpl(private val userDao: UserDao) {

//    val readAllData: List<User> = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

}