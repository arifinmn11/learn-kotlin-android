package com.example.latihanframgent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanframgent.data.model.Numbers

class NumberViewAdapter() : RecyclerView.Adapter<NumberViewHolder>() {

    var numbers = ArrayList<Numbers>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.number_layout, parent, false)
        return NumberViewHolder(itemView)
    }

    override fun getItemCount(): Int  = numbers.size

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        val number = numbers[position]
        holder.bind(number)
    }

    fun setData(data: List<Numbers>) {
        numbers.clear()
        numbers.addAll(data)
        notifyDataSetChanged()
    }

}