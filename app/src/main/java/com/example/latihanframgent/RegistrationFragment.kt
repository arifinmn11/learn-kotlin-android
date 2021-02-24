package com.example.latihanframgent

import androidx.appcompat.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.latihanframgent.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {
    lateinit var findController: NavController
    lateinit var sharedViewModel: MainActivityViewModel
    lateinit var viewModel: RegistrationViewModel
    lateinit var binding: FragmentRegistrationBinding
    lateinit var loadingDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        subscribe()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        loadingDialog = LoadingDialog.build(requireContext())
        binding = FragmentRegistrationBinding.inflate(layoutInflater)
        binding.apply {
            button2.setOnClickListener {
                val personName = editTextTextPersonName.text.toString()
                viewModel.inputNameValidation(personName)
            }
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun initViewModel() {
        sharedViewModel =
            ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
        viewModel = ViewModelProvider(this).get(RegistrationViewModel::class.java)
    }

    private fun subscribe() = viewModel.isNameValid.observe(this) {
        when (it.status) {
            ResourceStatus.LOADING -> {
                loadingDialog.show()
                println("LOADING DIALOG");
            }
            ResourceStatus.SUCCESS -> {
                loadingDialog.hide()
                println("SUCCESS DIALOG");
                sharedViewModel.sayHello("Hi Bang jago")
                findNavController().navigate(R.id.action_registrationFragment_to_helloFragment)
            }
            ResourceStatus.FAIL -> {

                println("FAIL DIALOG");
                loadingDialog.hide()
                Toast.makeText(
                    requireContext(),
                    it.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

}