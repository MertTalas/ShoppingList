package com.mert.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mert.shoppinglist.data.db.entities.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE) // if database have this item new data replace with actual data
    suspend fun upsert(item: ShoppingItem) // this method for both insert and update

    @Delete
    suspend fun delete(item: ShoppingItem) // delete shopping item func

    @Query("SELECT * FROM shopping_items") // query for accessing all shopping items
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>> // for efficient update recyclerview we return with livedata our objects
}