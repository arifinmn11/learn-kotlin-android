package com.example.latihanframgent.presentation.news_webview

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AlertDialog
import com.example.latihanframgent.R
import com.example.latihanframgent.component.LoadingDialog
import com.example.latihanframgent.databinding.FragmentWebViewBinding

class WebViewFragment : Fragment() {
    lateinit var binding: FragmentWebViewBinding
    private var link: String = "https://google.com"
    lateinit var loadingDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.get("link_article")?.let {
                link = it.toString()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadingDialog = LoadingDialog.build(requireContext())
        binding = FragmentWebViewBinding.inflate(layoutInflater)
        binding.apply {
            link?.let {
                if (it == "") webView.loadUrl(link)
                else webView.loadUrl(link)
            }
            webView.settings.setJavaScriptEnabled(true)
            webView.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    view?.loadUrl(url)
                    return true
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    loadingDialog.hide()
                }

                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    loadingDialog.show()
                }
            }
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = WebViewFragment()
    }
}