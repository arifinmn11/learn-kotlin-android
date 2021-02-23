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
import androidx.lifecycle.ViewModelProvider
import com.example.latihanframgent.R
import com.example.latihanframgent.databinding.FragmentAddItemBinding
import com.example.latihanframgent.presentations.viewmodel.ItemViewModel
import com.example.latihanframgent.utils.Item
import kotlinx.android.synthetic.main.fragment_add_item.*
import java.util.*


class AddItemFragment : Fragment() {
    lateinit var viewModel: ItemViewModel
    lateinit var binding: FragmentAddItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ItemViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddItemBinding.inflate(layoutInflater)
        binding.apply {
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
                    viewModel.addItem(item)
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
        return binding.root
    }

    private fun clearInput() {
        binding.etShopDate.setText("")
        binding.etQuantity.setText("")
        binding.etItem.setText("")
        binding.etNote.setText("")
    }
}

