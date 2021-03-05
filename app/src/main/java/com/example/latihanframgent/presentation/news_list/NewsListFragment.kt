package com.example.latihanframgent.presentation.news_list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.latihanframgent.R
import com.example.latihanframgent.data.repository.NewsApiRepositoryImpl
import com.example.latihanframgent.databinding.FragmentNewsListBinding

class NewsListFragment : Fragment() {

    lateinit var binding: FragmentNewsListBinding
    lateinit var newsViewModel : NewsListModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        subscribe()
        binding = FragmentNewsListBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.apply {
            newsViewModel.onGetNewsApi("kucing")
        }
        return binding.root
    }

    fun initViewModel() {
        newsViewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val repository = NewsApiRepositoryImpl()
                return NewsListModel(repository) as T
            }

        }).get(NewsListModel::class.java)
    }

    fun subscribe() {
        newsViewModel.newsArticleLiveData.observe(this) {
            Log.d("SUBSCRIBE", it)
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() = NewsListFragment()
    }
}