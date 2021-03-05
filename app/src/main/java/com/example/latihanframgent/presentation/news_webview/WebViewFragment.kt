package com.example.latihanframgent.presentation.news_webview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.latihanframgent.R
import com.example.latihanframgent.databinding.FragmentWebViewBinding

class WebViewFragment : Fragment() {
    lateinit var binding: FragmentWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentWebViewBinding.inflate(layoutInflater)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = WebViewFragment()
    }
}