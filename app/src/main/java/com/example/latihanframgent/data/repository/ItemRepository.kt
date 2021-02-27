package com.example.latihanframgent.data.repository

import com.example.latihanframgent.data.model.Item
import java.time.Instant
import java.time.LocalDate
import java.util.*

class ItemRepository : ItemRepositoryInterface {
    companion object {
        var itemList = arrayListOf(
            Item(
                UUID.randomUUID().toString(),
                "1/1/2020",
                "123",
                123,
                "note"
            ),
            Item(
                UUID.randomUUID().toString(),
                "2/1/2020",
                "123",
                123,
                "note"
            ),
            Item(
                UUID.randomUUID().toString(),
                "1/3/2020",
                "123",
                123,
                "note"
            )
        )
    }

    override fun list(): List<Item> = itemList


//    override fun add(item: Item) {
//        itemList.add(item)
//    }
//
//    override fun delete(item: Item) {
//        val itemPos = itemList.indexOf(item)
//        itemList.removeAt(itemPos)
//    }
//
//    override fun find(item: Item): Item {
//        val index = itemList.indexOf(item)
//        return itemList[index]
//    }
//
//    override fun finById(id: String): Item {
//        val item = itemList.filter { it.id == id }.single()
//        println(item.note)
//        return item
//    }
//
//
//    override fun update(data: Item): Item {
//        val item = itemList.filter {
//            it.id == data.id
//        }
//        val index = itemList.indexOf(item.single())
//        itemList[index] = data
//        return data
//    }

}