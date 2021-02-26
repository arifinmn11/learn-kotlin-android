package com.example.latihanframgent.data.repository

import com.example.latihanframgent.data.model.Item
import java.util.*

class ItemRepository :
    IItemRepository {
    companion object {
        var itemList = arrayListOf(
            Item(
                UUID.randomUUID().toString(),
                "ABC",
                "123",
                123,
                "note"
            ),
            Item(
                UUID.randomUUID().toString(),
                "ABC",
                "123",
                123,
                "note"
            ),
            Item(
                UUID.randomUUID().toString(),
                "ABC",
                "123",
                123,
                "note"
            )
        )
    }


    override fun add(item: Item) {
        itemList.add(item)
    }

    override fun delete(item: Item) {
        val itemPos = itemList.indexOf(item)
        itemList.removeAt(itemPos)
    }

    override fun find(item: Item): Item {
        val index = itemList.indexOf(item)
        return itemList[index]
    }

    override fun finById(id: String): Item {
        val item = itemList.filter { it.id == id }.single()
        println(item.note)
        return item
    }

    override fun list(): List<Item> = itemList

    override fun update(data: Item): Item {
        val item = itemList.filter {
            it.id == data.id
        }
        val index = itemList.indexOf(item.single())
        itemList[index] = data
        return data
    }

}