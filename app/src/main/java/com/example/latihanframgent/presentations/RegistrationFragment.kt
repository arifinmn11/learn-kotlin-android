package com.example.latihanframgent.presentations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.latihanframgent.R
import com.example.latihanframgent.interfaces.onNavigationListener
import com.example.latihanframgent.utils.PLAYER1_PARAM
import com.example.latihanframgent.utils.PLAYER2_PARAM
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_registration.*


class RegistrationFragment : Fragment(), View.OnClickListener {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
        btnPlay.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view) {
            btnPlay -> {
//                if (etPlayerName1.text.toString() != "" && etPlayerName2.text.toString() != "") {
//
//                    Toast.makeText(activity, "Input Player not be blank", Toast.LENGTH_LONG).show()
//
//                } else {
//                    PLAYER1_PARAM = etPlayerName1.text.toString()
//                    PLAYER2_PARAM = etPlayerName2.text.toString()
                    navController.navigate(R.id.action_registrationFragment_to_boardFragment)
//                }
            }
        }
    }
}
