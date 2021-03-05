package com.example.latihanframgent.presentation.news_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.latihanframgent.data.repository.NewsApiRepository
import com.example.latihanframgent.utils.ResourceState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsListModel(val repoository: NewsApiRepository) : ViewModel() {

    private var _newsArticleLiveData = MutableLiveData<String>()
    val newsArticleLiveData: LiveData<String>
        get() {
            return _newsArticleLiveData
        }

    fun onGetNewsApi(keyText: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repoository.getNews(keyText)
            if (response.isSuccessful) {
                response.body()?.let {
                    Log.d("RESPONSE DATA" , "$it")
                    _newsArticleLiveData.postValue(it.description)
                }
            } else {
                Log.d("RESPONSE DATA" , "ERROR")

            }
        }
    }

}