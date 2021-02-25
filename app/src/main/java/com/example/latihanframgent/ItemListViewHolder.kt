package com.example.latihanframgent

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanframgent.databinding.LayoutRecycleViewBinding

class ItemListViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {


    val binding = LayoutRecycleViewBinding.bind(view)

    fun bind(itemData: ItemData) {
        binding.apply {
            itemNameTv.text = itemData.name
            itemCategoryTv.text = itemData.category
            itemQtyTv.text = itemData.quantity.toString()
        }
    }
}