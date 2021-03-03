package com.example.latihanframgent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        subscribe()

        button_add.setOnClickListener {

            val age = edit_text_age.text.toString().toInt()
            val firstname = edit_text_firstname.text.toString()
            val lastname = edit_text_lastname.text.toString()
            userViewModel.addUser(User(firstname = firstname, age = age, lastname = lastname))
            clearInput()
        }

    }

    fun initViewModel() {
        userViewModel = ViewModelProvider(this,
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    val userDao = UserDatabase.getDatabase(this@MainActivity).userDao()
                    val userRepository = UserRepository(userDao)
                    return UserViewModel(userRepository) as T
                }
            }).get(UserViewModel::class.java)
    }

    fun subscribe() {
        userViewModel.getUsers().observe(this, Observer<List<User>> {
            list_view.text = it.joinToString("\n")
        })

    }

    fun clearInput() {
        edit_text_age.setText("")
        edit_text_firstname.setText("")
        edit_text_lastname.setText("")
    }


}
