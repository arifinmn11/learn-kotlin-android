package com.example.latihanframgent.presentations

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanframgent.R
import com.example.latihanframgent.utils.ItemList


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemName: TextView
        var itemQuantity: TextView
        var itemNote: TextView

        init {
            itemName = itemView.findViewById(R.id.tvItemName)
            itemQuantity = itemView.findViewById(R.id.tvQuantity)
            itemNote = itemView.findViewById(R.id.tvNote)

            itemView.setOnClickListener {
                var position: Int = adapterPosition
                val context = itemView.context
                val intent = Intent(context, ListItemFragment::class.java).apply {
                    putExtra("NUMBER", position)
                    putExtra("CODE", itemName.text)
                    putExtra("CATEGORY", itemQuantity.text)
                    putExtra("CONTENT", itemNote.text)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = ItemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemName.text = ItemList[position].itemName
        holder.itemQuantity.text = ItemList[position].quantity.toString()
        holder.itemNote.text = ItemList[position].note

    }
}