package com.example.latihanframgent.presentation.news_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanframgent.R
import com.example.latihanframgent.data.model.ArticlesItem

class NewsAdapter(val onClickListener: OnClickListener): RecyclerView.Adapter<NewsViewHolder>() {
    var articles = ArrayList<ArticlesItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.view_card, parent, false)
        return NewsViewHolder(v, onClickListener)
    }

    override fun getItemCount(): Int  = articles.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article)
    }

    fun setView(data: List<ArticlesItem>) {
        articles.clear()
        articles.addAll(data)
        notifyDataSetChanged()
    }
}