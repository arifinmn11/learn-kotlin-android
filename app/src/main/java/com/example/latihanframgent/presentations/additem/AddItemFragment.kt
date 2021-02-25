package com.example.latihanframgent.presentations.additem

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.example.latihanframgent.R
import com.example.latihanframgent.databinding.FragmentAddItemBinding
import com.example.latihanframgent.presentations.components.LoadingDialog
import com.example.latihanframgent.presentations.itemlist.ItemRepository
import com.example.latihanframgent.presentations.viewmodel.ValidationItemModel
import com.example.latihanframgent.presentations.viewmodel.ItemViewModel
import com.example.latihanframgent.utils.Item
import com.example.latihanframgent.utils.ResourceStatus
import java.util.*


class AddItemFragment : Fragment() {
    lateinit var model: ValidationItemModel
    lateinit var sharedViewModel: ItemViewModel
    lateinit var binding: FragmentAddItemBinding
    lateinit var loadingDialog: AlertDialog
    var item: Item? = null

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
                var intQty = 0
                if (!etQuantity.text.toString().isNullOrEmpty()) {
                    intQty = etQuantity.text.toString().toInt()
                }
                item = Item(
                    date = etShopDate.text.toString(),
                    quantity = intQty,
                    note = etNote.text.toString(),
                    itemName = etItem.text.toString()
                )
                model.validationItem(item!!)

            }
        }
        return binding.root
    }

    private fun initViewModel() {
        sharedViewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val repo = ItemRepository()
                return ItemViewModel(repo) as T
            }

        }).get(ItemViewModel::class.java)
        model = ViewModelProvider(this).get(ValidationItemModel::class.java)
    }

    private fun subscribe() = model.isValid.observe(this) {
        when (it.status) {
            ResourceStatus.LOADING -> {
                loadingDialog.show()
            }
            ResourceStatus.SUCCESS -> {
                sharedViewModel.onAddItem(item!!)
                clearInput()
                loadingDialog.hide()
                Toast.makeText(
                    requireContext(),
                    "Data has been saved!",
                    Toast.LENGTH_SHORT
                ).show()
                findNavController().navigate(R.id.action_global_listItemFragment)
            }
            ResourceStatus.FAIL -> {
                loadingDialog.hide()
                Toast.makeText(
                    requireContext(),
                    it.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun clearInput() {
        binding.etShopDate.setText("")
        binding.etQuantity.setText("")
        binding.etItem.setText("")
        binding.etNote.setText("")
    }
}

