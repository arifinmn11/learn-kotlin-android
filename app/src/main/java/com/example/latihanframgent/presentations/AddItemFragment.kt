package com.example.latihanframgent.presentations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.latihanframgent.R
import com.example.latihanframgent.utils.Item
import kotlinx.android.synthetic.main.fragment_add_item.*
import kotlinx.android.synthetic.main.fragment_list_item.*
import java.util.*


class AddItemFragment(private val onNavigationListener: OnNavigationListener) : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        buttonAdd.setOnClickListener {
            val item = Item(
                quantity = etQuantity.text.toString().toInt(),
                note = etNote.text.toString(),
                itemName = etItem.text.toString()
            )

            if (item != null) {
                onNavigationListener.addItem(item)
                Toast.makeText(
                    activity,
                    "Item : ${item.itemName} has been added",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun clearInput() {

    }

    companion object {
        @JvmStatic
        fun newInstance(onNavigationListener: OnNavigationListener) =
            AddItemFragment(onNavigationListener)
    }
}