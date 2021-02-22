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

    override fun getItemCount(): Int = ItemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemName.text = ItemList[position].itemName
        holder.itemQuantity.text = ItemList[position].quantity.toString()
        holder.itemNote.text = ItemList[position].note
        holder.itemDate.text = ItemList[position].date

    }
}