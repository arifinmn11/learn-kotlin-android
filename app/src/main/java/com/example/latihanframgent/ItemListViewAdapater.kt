package com.example.latihanframgent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemListViewAdapater(val items: ArrayList<ItemData>) :
    RecyclerView.Adapter<ItemListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_recycle_view, parent, false)
        return ItemListViewHolder(view)
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) {
        val product = items.get(position)
        holder.bind(product)
    }

}