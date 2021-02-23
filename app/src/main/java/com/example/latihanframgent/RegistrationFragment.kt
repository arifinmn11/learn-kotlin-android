package com.example.latihanframgent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.latihanframgent.databinding.FragmentRegistrationBinding

class RegistrationFragment(val onNavigationListener: OnNavigationListener) : Fragment() {
    lateinit var viewModel: MainActivityViewModel
    lateinit var binding: FragmentRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(layoutInflater)
        binding.apply {
            button2.setOnClickListener {
                val personName = editTextTextPersonName.text
                viewModel.sayHello("hi .. ${personName}")

                onNavigationListener.onHello()
            }
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(onNavigationListener: OnNavigationListener) =
            RegistrationFragment(onNavigationListener)
    }
}