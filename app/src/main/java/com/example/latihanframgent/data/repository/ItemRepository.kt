package com.example.latihanframgent.data.repository

import androidx.lifecycle.LiveData
import com.example.latihanframgent.data.dao.ItemDao
import com.example.latihanframgent.data.model.Item

class ItemRepository(private val itemDao: ItemDao) {

    suspend fun list(): LiveData<List<Item>> = itemDao.getItems()
    suspend fun list(page: Int?): LiveData<List<Item>> = itemDao.getItems()
    suspend fun save(item: Item) {
        if (item.id == 0) {
            itemDao.addItem(item)
        } else {
            itemDao.updateItem(item)
        }
    }
    suspend fun delete(item: Item) {
        itemDao.deleteItem(item)
    }

    suspend fun findById(item: Item) {
        itemDao.getItemById(item.id)
    }


//    override fun list(page: Int?): List<Item> {
//        val size = itemList.size
//        val from = (page!! * 5)
//        val to = from + 4
//        var limit = if (size - to < 0) {
//            to + (size - to)
//        } else {
//            to
//        }
//
//        val items = mutableListOf<Item>()
//        for (i in from until limit) {
//            items.add(itemList[i])
//        }
//
//        return items
//    }

//    override fun save(data: Item): Item {
//        if (data.id == 0) {
//            data.id = 1
//            itemList.add(data)
//        } else {
//            val item = itemList.filter {
//                it.id == data.id
//            }
//            val index = itemList.indexOf(item.single())
//            itemList[index] = data
//        }
//        return data
//    }
//    override fun delete(item: Item): Item {
//        val index = itemList.indexOf(item)
//        itemList.removeAt(index)
//        return item
//    }
//
//    override fun findByItem(item: Item): Item = itemList?.get(itemList.indexOf(item))

}