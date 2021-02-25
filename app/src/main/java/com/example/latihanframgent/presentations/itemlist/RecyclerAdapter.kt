package com.example.latihanframgent.presentations.itemlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanframgent.R
import com.example.latihanframgent.utils.Item


class RecyclerAdapter(private val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<ItemViewHolder>() {

    var items = ArrayList<Item>()

//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var itemName: TextView = itemView.findViewById(R.id.tvItemName)
//        var itemQuantity: TextView = itemView.findViewById(R.id.tvQuantity)
//        var itemNote: TextView = itemView.findViewById(R.id.tvNote)
//        var itemDate: TextView = itemView.findViewById(R.id.tvDate)
//    }


    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.card_view, parent, false)
        return ItemViewHolder(itemView, itemClickListener)
    }

    fun setData(newItemList: List<Item>) {
        items.clear()
        items.addAll(newItemList)
        notifyDataSetChanged()
    }
}