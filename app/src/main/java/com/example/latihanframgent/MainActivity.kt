package com.example.latihanframgent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController;
    lateinit var navHostFragment: NavHostFragment
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setupWithNavController(navController)

//        bottom_navigation.setOnNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.account_menu -> findNavController(R.id.nav_host_fragment).navigate(R.id.action_global_accountFragment)
//                R.id.add_menu -> findNavController(R.id.nav_host_fragment).navigate(R.id.action_global_addItemFragment)
//                R.id.history_menu -> findNavController(R.id.nav_host_fragment).navigate(R.id.action_global_historyFragment)
//                R.id.list_menu -> findNavController(R.id.nav_host_fragment).navigate(R.id.action_global_listFragment)
//            }
//            true
//        }

    }


}
