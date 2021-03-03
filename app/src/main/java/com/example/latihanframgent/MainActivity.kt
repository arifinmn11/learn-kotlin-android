package com.example.latihanframgent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        userViewModel.addUser(
            User(
                firstname = "Arifin",
                age = 12,
                lastname = "Nur"
            )
        )

    }

    fun initViewModel() {
        userViewModel = ViewModelProvider(this,
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    val userDao = UserDatabase.getDatabase(this@MainActivity).userDao()
                    val userRepository = UserRepositoryImpl(userDao)
                    return UserViewModel(userRepository) as T
                }
            }).get(UserViewModel::class.java)
    }


}
