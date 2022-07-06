package com.mert.shoppinglist.ui.shoppinglist

import com.mert.shoppinglist.data.db.entities.ShoppingItem

interface AddDialogListener {

    fun onAddButtonClicked(item: ShoppingItem)
}