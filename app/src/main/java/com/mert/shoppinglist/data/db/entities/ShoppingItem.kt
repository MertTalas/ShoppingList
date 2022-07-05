package com.mert.shoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items") // our table name
data class ShoppingItem(
    @ColumnInfo(name = "item_name") // our column name
    var name: String,

    @ColumnInfo(name = "item_amount") // our column name
    var amount: Int
){
    @PrimaryKey(autoGenerate = true) // unique id for each item
    var id: Int? = null // can be null
}
