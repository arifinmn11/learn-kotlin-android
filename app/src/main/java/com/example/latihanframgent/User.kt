package com.example.latihanframgent

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mst_user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val firstname: String,
    val lastname: String,
    val age: Int
)