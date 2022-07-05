package com.mert.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.mert.shoppinglist.data.db.entities.ShoppingItem
import com.mert.shoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
): ViewModel() {

    fun upsert(item : ShoppingItem) = CoroutineScope(Dispatchers.Main).launch { // we are calling upsert method in main coroutine thread
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch { // we are calling delete method in main coroutine thread
        repository.delete(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItems() // we don't need coroutine for its read operation
}