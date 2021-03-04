package com.example.latihanframgent.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.latihanframgent.data.model.Item

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addItem(item: Item)

    @Query("select * from mst_item")
    fun getItems(): LiveData<List<Item>>

    @Update
    suspend fun updateItem(item: Item)

    @Delete
    suspend fun deleteItem(item: Item)

    @Query("select * from mst_item where id = :id")
    fun getItemById(id: Int): LiveData<Item>

}