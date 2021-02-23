package com.example.latihanframgent.presentations.itemlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanframgent.R
import com.example.latihanframgent.utils.Item
import com.example.latihanframgent.utils.ItemList


class RecyclerAdapter(private val items: MutableList<Item>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemName: TextView = itemView.findViewById(R.id.tvItemName)
        var itemQuantity: TextView = itemView.findViewById(R.id.tvQuantity)
        var itemNote: TextView = itemView.findViewById(R.id.tvNote)
        var itemDate: TextView = itemView.findViewById(R.id.tvDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemName.text = items[position].itemName
        holder.itemQuantity.text = items[position].quantity.toString()
        holder.itemNote.text = items[position].note
        holder.itemDate.text = items[position].date
    }
}