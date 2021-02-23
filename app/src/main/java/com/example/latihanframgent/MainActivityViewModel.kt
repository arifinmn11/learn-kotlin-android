package com.example.latihanframgent

import androidx.lifecycle.ViewModel
import com.example.latihanframgent.databinding.ActivityMainBinding

class MainActivityViewModel : ViewModel() {
    var helloWorld: String? = null

    fun sayHello(word: String) {
        helloWorld = word
    }
}