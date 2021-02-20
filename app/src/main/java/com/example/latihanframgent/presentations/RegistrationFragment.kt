package com.example.latihanframgent.presentations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.latihanframgent.R
import com.example.latihanframgent.interfaces.onNavigationListener
import kotlinx.android.synthetic.main.fragment_registration.*


class RegistrationFragment(private val onNavigationListener: onNavigationListener) : Fragment() {

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
        btnPlay.setOnClickListener {
            val player1 = etPlayerName2.text
            val player2 = etPlayerName2.text
            onNavigationListener.onRegistration(
                player1 = player1.toString(),
                player2 = player2.toString()
            )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(onNavigationListener: onNavigationListener) =
            RegistrationFragment(onNavigationListener)
    }
}