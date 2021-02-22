package com.example.latihanframgent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment(), View.OnClickListener {
    private lateinit var navController: NavController;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnNavListItem.setOnClickListener(this)
    }

    companion object {

        @JvmStatic
        fun newInstance() = ListFragment()

    }

    override fun onClick(v: View?) {
        when (v) {
            btnNavListItem -> navController.navigate(R.id.action_listFragment_to_addItemFragment)
        }
    }
}