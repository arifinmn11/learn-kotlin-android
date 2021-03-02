package com.example.latihanframgent.data.repository

import com.example.latihanframgent.data.model.Numbers

interface RepositoryNumber {
    fun add(data: Numbers): Numbers
    fun getList(): List<Numbers>
    fun clear()
}