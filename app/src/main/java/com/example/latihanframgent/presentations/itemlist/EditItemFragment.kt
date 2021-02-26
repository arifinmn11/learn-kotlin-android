package com.example.latihanframgent.presentations.itemlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import com.example.latihanframgent.R
import com.example.latihanframgent.data.model.Item
import com.example.latihanframgent.data.repository.ItemRepository
import com.example.latihanframgent.databinding.FragmentEditItemBinding
import com.example.latihanframgent.presentations.viewmodel.ItemViewModel

class EditItemFragment : Fragment() {
    private var itemGet: Item? = null
    private lateinit var binding: FragmentEditItemBinding
    private lateinit var viewModel: ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            itemGet = it.getParcelable<Item>("item_get")
        }
        initViewModel()
        subscribe()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditItemBinding.inflate(inflater)
        binding.apply {
            itemGet?.apply {
                etItem.setText(itemName)
                etShopDate.setText(date)
                etNote.setText(note)
                etQuantity.setText(quantity.toString())
            }
            buttonEditItem.setOnClickListener {
                viewModel.onUpdate(
                    Item(
                        id = itemGet?.id.toString(),
                        quantity = etQuantity.text.toString().toInt(),
                        note = etNote.text.toString(),
                        date = etShopDate.text.toString(),
                        itemName = etItem.text.toString()
                    )
                )
            }
            buttonCancel.setOnClickListener {
                Navigation.findNavController(requireView()).popBackStack()
            }
        }
        return binding.root
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val repository = ItemRepository()
                return ItemViewModel(repository) as T
            }
        }).get(ItemViewModel::class.java)
    }

    private fun subscribe() {
        viewModel.itemLiveData.observe(this) {
            Navigation.findNavController(requireView())
                .navigate(R.id.action_global_listItemFragment, bundleOf("result" to it))
        }
    }
}