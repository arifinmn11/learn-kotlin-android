package com.example.latihanframgent.data.repository

import android.util.Log
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
    override fun list(page: Int?): List<Item> {
        val size = itemList.size
        val from = (page!! * 5)
        val to = from + 4
        var limit = if (size - to < 0) {
            to + (size - to)
        } else {
            to
        }

        val items = mutableListOf<Item>()
        for (i in from until limit) {
            items.add(itemList[i])
        }

        return items
    }

    override fun save(data: Item): Item {
        if (data.id == "") {
            data.id = UUID.randomUUID().toString()
            itemList.add(data)
        } else {
            val item = itemList.filter {
                it.id == data.id
            }
            val index = itemList.indexOf(item.single())
            itemList[index] = data
        }
        return data
    }

    override fun delete(item: Item): Item {
        val index = itemList.indexOf(item)
        itemList.removeAt(index)
        return item
    }

    override fun findByItem(item: Item): Item = itemList?.get(itemList.indexOf(item))

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