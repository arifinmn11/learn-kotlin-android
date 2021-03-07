package com.example.latihanframgent.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihanframgent.R
import com.example.latihanframgent.data.repository.ItemRepositoryImpl
import com.example.latihanframgent.databinding.FragmentListBinding
import com.example.latihanframgent.utils.components.LoadingDialog
import kotlinx.coroutines.Job

class ListFragment : Fragment() {

    lateinit var viewModel: ListViewModel
    lateinit var binding: FragmentListBinding
    lateinit var rvAdapter: ListViewAdapter
    lateinit var loadingDialog: AlertDialog
    private var page = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        subscribe()
        subscribeButtonDelete()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadingDialog = LoadingDialog.build(requireContext())
        binding = FragmentListBinding.inflate(layoutInflater)
        binding.apply {
            rvAdapter = ListViewAdapter(viewModel)
            recyclerViewItem.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = rvAdapter
            }

        }
        return binding.root
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val getItemRepo = ItemRepositoryImpl()
                return ListViewModel(getItemRepo) as T
            }
        }).get(ListViewModel::class.java)
    }

    private fun subscribe() {
        viewModel.getItemList().observe(requireActivity()) {
            loadingDialog.show()
            when (it?.status) {
                400 -> {
                    loadingDialog.hide()
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                200 -> {
                    loadingDialog.hide()
                    rvAdapter.setData(it.data)
                }
            }
        }
    }

    private fun subscribeButtonDelete() {
        viewModel.deleteLiveButton.observe(this) {
            viewModel.deleteItem(it).observe(this) {
                loadingDialog.show()
                when (it?.status) {
                    400 -> {
                        loadingDialog.hide()
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    }
                    200 -> {
                        loadingDialog.hide()
                        subscribe()
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = ListFragment()
    }
}