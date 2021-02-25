package com.example.latihanframgent.presentations.itemlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihanframgent.databinding.FragmentListItemBinding
import com.example.latihanframgent.presentations.viewmodel.ItemViewModel
import kotlinx.android.synthetic.main.fragment_list_item.*


class ListItemFragment : Fragment() {
    lateinit var viewModel: ItemViewModel
    lateinit var binding: FragmentListItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ItemViewModel::class.java)
        subscribe()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListItemBinding.inflate(layoutInflater)
        viewModel.getItem()
        return binding.root
    }

    private fun subscribe() {
        viewModel.getItemLive.observe(this, Observer {
            recycler_view.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = RecyclerAdapter(it);
            }
        })
    }

}