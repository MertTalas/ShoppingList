package com.mert.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mert.shoppinglist.data.db.entities.ShoppingItem

@Database(entities = [ShoppingItem::class], version = 1) // gives our entity names to database, and db version
abstract class ShoppingDatabase: RoomDatabase() { // RoomDatabase is android sqlite database actually

    abstract fun getShoppingDao(): ShoppingDao // for access db operations inside database class

    companion object{ //companion==static in java, we create an instance for singleton using everywhere
        @Volatile // writing on just one thread, we want don't to duplicate instance variable
        private var instance: ShoppingDatabase?=null
        private var LOCK= Any()

        // this func executed always beginning of when create an ShoppingDatabase object
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){ // synchronized= no other threads can access that instance in the same time
            instance ?: createDatabase(context).also { // if instance is null creating new database and with "also" we set our new db to instance of it
                instance =it
            }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder( // RoomDatabase build func
            context.applicationContext,
            ShoppingDatabase::class.java,
            "ShoppingDb.db").build()
    }
}