package com.example.latihanframgent.presentations.itemlist

import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanframgent.databinding.CardViewBinding
import com.example.latihanframgent.utils.Item

class ItemViewHolder(view: View, val clickListener: ItemClickListener) :
    RecyclerView.ViewHolder(view) {
    val binding = CardViewBinding.bind(view)

    fun bind(item: Item) {
        binding.apply {
            tvDate.setText(item.date)
            tvItemName.setText(item.itemName)
            tvNote.setText(item.note)
            tvQuantity.setText(item.quantity.toString())
            buttonDelete.setOnClickListener {
                clickListener.onDelete(item)
            }
            cardItem.setOnClickListener {
                println("PRESS!")
            }
        }
    }
}