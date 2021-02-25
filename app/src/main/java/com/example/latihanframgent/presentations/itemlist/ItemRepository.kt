package com.example.latihanframgent.presentations.itemlist

import com.example.latihanframgent.utils.Item

class ItemRepository : IItemRepository {
    companion object {
        var itemList = arrayListOf(
            Item("ABC", "123", 123, "note"),
            Item("ABC", "123", 123, "note"),
            Item("ABC", "123", 123, "note")
        )
    }


    override fun add(item: Item) {
       itemList.add(item)
    }

    override fun delete(item: Item) {
        val itemPos = itemList.indexOf(item)
        itemList.removeAt(itemPos)
    }

    override fun list(): List<Item> = itemList

}