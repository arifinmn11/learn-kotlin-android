package com.example.latihanframgent.presentations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.latihanframgent.R
import com.example.latihanframgent.utils.ADD_ITEM
import com.example.latihanframgent.utils.Item
import com.example.latihanframgent.utils.ItemList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListItemFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListItemFragment(private val onNavigationListener: OnNavigationListener) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    companion object {
        @JvmStatic
        fun newInstance(onNavigationListener: OnNavigationListener) =
            ListItemFragment(onNavigationListener)
    }
}
