package com.example.latihanframgent.presentations.itemlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihanframgent.databinding.ActivityMainBinding
import com.example.latihanframgent.databinding.FragmentListItemBinding
import com.example.latihanframgent.presentations.viewmodel.ItemViewModel
import kotlinx.android.synthetic.main.fragment_list_item.*


class ListItemFragment : Fragment() {
    lateinit var viewModel: ItemViewModel
    lateinit var binding: FragmentListItemBinding
    lateinit var rvAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
            rvAdapter = RecyclerAdapter(viewModel)

            recycler_view.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = rvAdapter
            }
        }
    }

    private fun subscribe() {
        viewModel.itemLiveData.observe(this) {
            rvAdapter.setData(it)
        }
    }

    fun initViewModel() {
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val repo = ItemRepository()
                return ItemViewModel(repo) as T
            }

        }).get(ItemViewModel::class.java)
    }


//        viewModel.getItemLive.observe(this, Observer {
//            recycler_view.apply {
//                layoutManager = LinearLayoutManager(activity)
//                adapter = RecyclerAdapter(it);
//            }
//        })s

}