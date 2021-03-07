package com.example.latihanframgent.data.model

import com.google.gson.annotations.SerializedName

data class ResponseItems(

	@field:SerializedName("data")
	val data: List<Item>,

	@field:SerializedName("message")
	var message: String,

	@field:SerializedName("status")
	var status: Int
)