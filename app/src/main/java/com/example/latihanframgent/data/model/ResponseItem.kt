package com.example.latihanframgent.data.model

import com.google.gson.annotations.SerializedName

data class ResponseItem(

    @field:SerializedName("data")
    val data: Item?,

    @field:SerializedName("message")
    val message: String?,

    @field:SerializedName("status")
    val status: Int
)