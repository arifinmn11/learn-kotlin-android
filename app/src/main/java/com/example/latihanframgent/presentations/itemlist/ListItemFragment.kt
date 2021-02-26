package com.example.latihanframgent.presentations.itemlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihanframgent.R
import com.example.latihanframgent.data.repository.ItemRepository
import com.example.latihanframgent.databinding.FragmentListItemBinding
import com.example.latihanframgent.utils.components.EditDialogItem
import com.example.latihanframgent.presentations.viewmodel.ItemViewModel
import kotlinx.android.synthetic.main.fragment_list_item.*


class ListItemFragment : Fragment() {
    lateinit var viewModel: ItemViewModel
    lateinit var binding: FragmentListItemBinding
    lateinit var rvAdapter: ItemAdapter
    lateinit var editDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        editDialog = EditDialogItem.build(requireContext())
        binding = FragmentListItemBinding.inflate(layoutInflater)
        initViewModel()
        subscribe()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListItemBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            rvAdapter = ItemAdapter(viewModel)

            recycler_view.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = rvAdapter
            }
        }
    }

    private fun subscribe() {
        viewModel.itemsLiveData.observe(this) {
            rvAdapter.setData(it)
        }

        viewModel.itemLiveData.observe(this) {
            Navigation.findNavController(requireView()).navigate(
                R.id.action_listItemFragment_to_editItemFragment,
                bundleOf("item_get" to it)
            )
        }
    }

    fun initViewModel() {
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val repo =
                    ItemRepository()
                return ItemViewModel(repo) as T
            }
        }).get(ItemViewModel::class.java)
    }


}