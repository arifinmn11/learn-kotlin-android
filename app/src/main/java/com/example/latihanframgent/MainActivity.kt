package com.example.latihanframgent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        subscribe()
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
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    val userDao = UserDatabase.getDatabase(this@MainActivity).userDao()
                    val userRepository = UserRepositoryImpl(userDao)
                    return UserViewModel(userRepository) as T
                }
            }).get(UserViewModel::class.java)
    }

    fun subscribe() {
        CoroutineScope(Dispatchers.IO).launch {
            userViewModel.getUser()
            val data = userViewModel.ListData
            Log.d("DATA USER : ", "${data.value}")
        }
    }


}
