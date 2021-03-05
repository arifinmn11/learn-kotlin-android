package com.example.latihanframgent.presentation.news_list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihanframgent.R
import com.example.latihanframgent.component.LoadingDialog
import com.example.latihanframgent.data.model.ResponseArticle
import com.example.latihanframgent.data.repository.NewsApiRepositoryImpl
import com.example.latihanframgent.databinding.FragmentNewsListBinding
import com.example.latihanframgent.utils.ResourceStatus

class NewsListFragment : Fragment() {

    lateinit var binding: FragmentNewsListBinding
    lateinit var newsViewModel : NewsListModel
    lateinit var rvAdapter: NewsAdapter
    lateinit var loadingDialog: AlertDialog

    private var topic = "tesla"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        subscribe()
        loadingDialog = LoadingDialog.build(requireContext())
        binding = FragmentNewsListBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        newsViewModel.onGetNewsApi(topic)
        binding.apply {

            searchButton.setOnClickListener{
                topic  = searchInput.text.toString()
                newsViewModel.onGetNewsApi(topic)
            }

            rvAdapter = NewsAdapter(newsViewModel)
            newsList.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = rvAdapter
            }
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
            when (it.resourceStatus) {
                ResourceStatus.LOADING -> loadingDialog.show()
                ResourceStatus.SUCCESS -> {
                    loadingDialog.hide()
                    val info: ResponseArticle = it.data as ResponseArticle
                    rvAdapter.setView(info.articles)
                }
                ResourceStatus.FAIL ->  {
                    loadingDialog.hide()
                    Toast.makeText(requireContext(), "${it.message}", Toast.LENGTH_LONG).show()
                }
            }
        }

        newsViewModel.linkArticleLiveData.observe(this) {
            Log.d("SUBSCRIBE", it)
            Navigation.findNavController(requireView()).navigate(R.id.action_global_webViewFragment,
            bundleOf("link_article" to it))
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = NewsListFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}