package com.example.latihanframgent

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.latihanframgent.data.model.Numbers
import com.example.latihanframgent.data.repository.RepositoryNumberImpl
import kotlinx.coroutines.*

class MainViewModel(private val repository: RepositoryNumberImpl) : ViewModel() {
    private var _numbers = MutableLiveData<List<Numbers>>()
    private var _number = MutableLiveData<Numbers>()
    private lateinit var job: Job
    val delayTime = 200


//    init {
//        getNumbers()
//    }

    val numbers: LiveData<List<Numbers>>
        get() {
            return _numbers
        }


    fun getNumbers() {
        _numbers.value = repository.getList()
    }

    fun addNumber(number: Int) {
        repository.clear()

        job = CoroutineScope(Dispatchers.Default).launch {
            for (i in 1..number) {
                launch {
                    if (i % 2 == 0) {
                        Log.d("GENAP", "$i GENAP")
                        repository.add(Numbers(i, "EVEN"))
                    } else {
                        Log.d("GANJIL", "$i GANJIL")
                        repository.add(Numbers(i, "ODD"))
                    }
                    Log.d("THREAD", "${Thread.currentThread().name}")
                    _numbers.postValue(repository.getList())
                }
            }
        }
    }
}