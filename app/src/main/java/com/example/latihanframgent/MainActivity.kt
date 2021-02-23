package com.example.latihanframgent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.latihanframgent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnNavigationListener {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel
    lateinit var registrationFragment: RegistrationFragment
    lateinit var helloFragment: HelloFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registrationFragment = RegistrationFragment.newInstance(this)
        helloFragment = HelloFragment.newInstance()
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.helloWorld?.let {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, helloFragment).commit()
        } ?: let {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, registrationFragment).commit()
        }
    }

    override fun onHello() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, helloFragment)
            .commit()
    }
}

//package com.example.viewmodel
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import androidx.lifecycle.ViewModelProvider
//import com.example.viewmodel.databinding.ActivityMainBinding
//
//class MainActivity : AppCompatActivity(), OnNavigationListener {
//    lateinit var binding: ActivityMainBinding
//    lateinit var helloFragment: HelloFragment
//    lateinit var registrationFragment: RegistrationFragment
//    lateinit var viewModel : MainActivityViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        //inflate -> cangklongin xml dengan class
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        registrationFragment = RegistrationFragment.newInstance(this)
//        helloFragment = HelloFragment.newInstance()
//        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
//        viewModel.helloWord?.let {
//            supportFragmentManager.beginTransaction().
//            replace(R.id.fragmentContainer, helloFragment).commit()
//        } ?: let {
//            supportFragmentManager.beginTransaction().
//            replace(R.id.fragmentContainer, registrationFragment).commit()
//        }
//    }
//
//    override fun onHello() {
//        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, helloFragment).commit()
//    }
//}
