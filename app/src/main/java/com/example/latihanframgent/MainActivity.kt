package com.example.latihanframgent

import android.graphics.drawable.DrawableContainer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var itemListRecyclerView: RecyclerView
    private lateinit var itemListViewAdapater: ItemListViewAdapater

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemListRecyclerView = findViewById(R.id.itemList_recycle_view)
        itemListViewAdapater = ItemListViewAdapater(
            arrayListOf(
                ItemData("a", 1, "tedt"),
                ItemData("a", 1, "tedt"),
                ItemData("a", 1, "tedt"),
                ItemData("a", 1, "tedt"),
                ItemData("a", 1, "tedt"),
                ItemData("a", 1, "tedt"),
                ItemData("a", 1, "tedt"),
                ItemData("a", 1, "tedt"),
                ItemData("a", 1, "tedt"),
                ItemData("a", 1, "tedt")
            )
        )
        itemListRecyclerView.layoutManager = LinearLayoutManager(this)
        itemListRecyclerView.adapter = itemListViewAdapater
    }


}
