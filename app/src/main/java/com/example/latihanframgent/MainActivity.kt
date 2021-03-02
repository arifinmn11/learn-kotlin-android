package com.example.latihanframgent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihanframgent.data.repository.RepositoryNumber
import com.example.latihanframgent.data.repository.RepositoryNumberImpl
import com.example.latihanframgent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvAdapter: NumberViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        initViewModel()
        subscribe()
        binding.apply {
            setContentView(root)
            rvAdapter = NumberViewAdapter()
            numberRecyclerview.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = rvAdapter
            }

            startButton.setOnClickListener {
                val number = inputNumberText.text.toString().toInt()
                viewModel.addNumber(number)
            }
        }

    }

    fun initViewModel() {
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val repo = RepositoryNumberImpl()
                return MainViewModel(repo) as T
            }

        }).get(MainViewModel::class.java)
    }

    fun subscribe() {
        viewModel.numbers.observe(this) {
            Log.d("debug numbers", "$it")
            rvAdapter.setData(it)
        }
    }

}
