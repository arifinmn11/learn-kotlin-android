package com.example.latihanframgent.data.model

import com.google.gson.annotations.SerializedName

data class Item(
	@field:SerializedName("date")
	val date: String,

	@field:SerializedName("note")
	val note: String,

	@field:SerializedName("quantity")
	val quantity: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int
)