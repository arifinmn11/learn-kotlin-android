package com.example.latihanframgent.presentation.news_list

import android.util.Log
import android.view.View
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.latihanframgent.data.model.ArticlesItem
import com.example.latihanframgent.databinding.ViewCardBinding

class NewsViewHolder(val view: View, val onClickListener: OnClickListener) :
    RecyclerView.ViewHolder(view) {
    private val binding = ViewCardBinding.bind(view)
    fun bind(article: ArticlesItem) {
        binding.apply {
            titleView.text = article.title
            dateView.text = article.publishedAt
            descriptionView.text = article.description
            Glide.with(view).load(article.urlToImage).into(imageView);
            linkButton.setOnClickListener {
                onClickListener.onMoveToLink(article.url)
            }
        }
    }
}