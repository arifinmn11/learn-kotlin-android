package com.example.latihanframgent.presentations.additem

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.latihanframgent.R
import com.example.latihanframgent.utils.Item
import com.example.latihanframgent.utils.ItemList
import kotlinx.android.synthetic.main.fragment_add_item.*
import java.util.*


class AddItemFragment : Fragment() {
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

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        etShopDate.setInputType(InputType.TYPE_NULL)
        etShopDate.setOnClickListener(View.OnClickListener {
            val datePickerDialog = activity?.let { it1 ->
                DatePickerDialog(
                    it1, DatePickerDialog.OnDateSetListener
                    { view, year, monthOfYear, dayOfMonth ->
                        etShopDate.setText(
                            "$year/$monthOfYear/$dayOfMonth",
                            TextView.BufferType.EDITABLE
                        );
                    }, year, month, day
                )
            }
            datePickerDialog?.show()
        })

        buttonAdd.setOnClickListener {
            if (etShopDate.text.toString() != "" &&
                etQuantity.text.toString() != "" &&
                etItem.text.toString() != "" &&
                etNote.text.toString() != ""
            ) {
                val item = Item(
                    date = etShopDate.text.toString(),
                    quantity = etQuantity.text.toString().toInt(),
                    note = etNote.text.toString(),
                    itemName = etItem.text.toString()
                )
                ItemList.add(item)
                clearInput()

                Toast.makeText(
                    activity,
                    "Item : ${item.itemName} has been added",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    activity,
                    "Input not be blank!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun clearInput() {
        etShopDate.setText("")
        etQuantity.setText("")
        etItem.setText("")
        etNote.setText("")
    }

}