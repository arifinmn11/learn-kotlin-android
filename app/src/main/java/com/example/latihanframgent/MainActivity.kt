package com.example.latihanframgent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

//        println(viewModel.helloWorld)

//        viewModel.helloWorld?.let {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, registrationFragment).commit()
//        } ?: let {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, helloFragment).commit()
//        }
    }

    override fun onHello() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, helloFragment)
            .commit()
    }
}
