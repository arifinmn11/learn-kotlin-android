package com.example.latihanframgent

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanframgent.data.model.Numbers
import com.example.latihanframgent.databinding.NumberLayoutBinding

class NumberViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = NumberLayoutBinding.bind(view)

    fun bind(number: Numbers) {
        binding.apply {
            numberText.text = number.number.toString()
            description.text = number.description
        }
    }
}