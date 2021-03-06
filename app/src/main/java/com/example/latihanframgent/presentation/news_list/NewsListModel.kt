package com.example.latihanframgent.presentation.news_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.latihanframgent.data.repository.NewsApiRepository
import com.example.latihanframgent.utils.ResourceState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsListModel(val repoository: NewsApiRepository) : ViewModel(), OnClickListener {

    private var _newsArticleLiveData = MutableLiveData<ResourceState>()
    private var _linkArticleLiveData = MutableLiveData<String>()
    private var _pageLiveData = MutableLiveData<Int>(1)
    private var _topicLiveData = MutableLiveData<String>( "tesla")



    val newsArticleLiveData: LiveData<ResourceState>
        get() {
            return _newsArticleLiveData
        }

    val linkArticleLiveData: LiveData<String>
        get() {
            return _linkArticleLiveData
        }

    val pageLiveData: LiveData<Int>
        get() {
            return _pageLiveData
        }

    val topicLiveData: LiveData<String>
        get() {
            return _topicLiveData
        }

    fun onNextPage() {
        _pageLiveData.postValue(_pageLiveData.value?.toInt()?.plus(1))
    }

    fun onPrevPage() {
        if(_pageLiveData.value?.toInt()!! > 1)
        _pageLiveData.postValue(_pageLiveData.value?.toInt()?.minus(1))
    }

    fun onSearchTopic(topic: String) {
        _topicLiveData.postValue(topic)
    }

    fun onGetArticlesApi(keyText: String, page: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            _newsArticleLiveData.postValue(ResourceState.loading())
            val response = repoository.getNews(keyText, page)
            if (response.isSuccessful) {
                response.body()?.let {
                    _newsArticleLiveData.postValue(ResourceState.success(it))
                }
            } else {
                _newsArticleLiveData.postValue(ResourceState.error("Sorry, request timeout ..."))
            }
        }
    }

    override fun onMoveToBrowser(link: String) {
        _linkArticleLiveData.postValue(link)
    }

}