package com.example.latihanframgent.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanframgent.data.model.Item
import com.example.latihanframgent.databinding.CardViewItemBinding


class ListViewHolder(view: View) :
    RecyclerView.ViewHolder(view) {
    private val binding = CardViewItemBinding.bind(view)
    fun bind(item: Item) {
        binding.apply {
            nameTv.text = item.name
            quantityTv.text = item.quantity.toString()
            dateTv.text = item.date
            noteTv.text = item.note
        }
    }
}
