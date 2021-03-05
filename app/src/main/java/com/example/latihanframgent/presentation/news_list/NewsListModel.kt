package com.example.latihanframgent.presentation.news_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.latihanframgent.data.model.ArticlesItem
import com.example.latihanframgent.data.model.ResponseArticle
import com.example.latihanframgent.data.repository.NewsApiRepository
import com.example.latihanframgent.utils.ResourceState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsListModel(val repoository: NewsApiRepository) : ViewModel(), OnClickListener {
//    ResponseArticle
    private var _newsArticleLiveData = MutableLiveData<ResourceState>()
    private var _linkArticleLiveData = MutableLiveData<String>()

    val newsArticleLiveData: LiveData<ResourceState>
        get() {
            return _newsArticleLiveData
        }

    val linkArticleLiveData: LiveData<String>
        get() {
            return _linkArticleLiveData
        }

    fun onGetNewsApi(keyText: String) {
        CoroutineScope(Dispatchers.IO).launch {
            _newsArticleLiveData.postValue(ResourceState.loading())
            val response = repoository.getNews(keyText)
            if (response.isSuccessful) {
                response.body()?.let {
                    _newsArticleLiveData.postValue(ResourceState.success(it))
                }
            } else {
                _newsArticleLiveData.postValue(ResourceState.error("Sorry, request timeout ..."))
            }
        }
    }

    override fun onMoveToLink(link: String) {
        _linkArticleLiveData.postValue(link)
    }

}