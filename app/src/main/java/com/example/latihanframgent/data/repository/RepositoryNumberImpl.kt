package com.example.latihanframgent.data.repository

import com.example.latihanframgent.data.model.Numbers

class RepositoryNumberImpl :
    RepositoryNumber {
    companion object {
        var ListNumbers = arrayListOf<Numbers>(
            Numbers(1,"test"),
            Numbers(2,"test"),
            Numbers(3,"test"),
            Numbers(4,"test")
        )
    }

    override fun add(data: Numbers): Numbers {
        ListNumbers.add(data)
        return data
    }

    override fun getList(): List<Numbers> {
        return ListNumbers
    }

    override fun clear() {
        ListNumbers.clear()
    }
}