package com.example.latihanframgent.presentations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.latihanframgent.R
import com.example.latihanframgent.interfaces.onNavigationListener

class MainActivity : AppCompatActivity(), onNavigationListener {

    private lateinit var splashScreenFragment: SplashScreenFragment
    private lateinit var registrationFragment: RegistrationFragment
    private lateinit var boardFragment: BoardFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        splashScreenFragment = SplashScreenFragment.newInstance(this)
        switchFragment(splashScreenFragment)

    }

    override fun onRegistration(player1: String, player2: String) {
        boardFragment = BoardFragment.newInstance(player1, player2, this)
        switchFragment(boardFragment)
    }

    override fun onSplash() {
        registrationFragment = RegistrationFragment.newInstance(this)
        switchFragment(registrationFragment)
    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
