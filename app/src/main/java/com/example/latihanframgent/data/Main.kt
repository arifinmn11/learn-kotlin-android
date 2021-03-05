package com.example.latihanframgent.data

import com.google.gson.annotations.SerializedName

data class Main(

	@field:SerializedName("temp")
	val temp: Double,

	@field:SerializedName("temp_min")
	val tempMin: Double,

	@field:SerializedName("humidity")
	val humidity: Int,

	@field:SerializedName("pressure")
	val pressure: Int,

	@field:SerializedName("temp_max")
	val tempMax: Double
)