package com.mert.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mert.shoppinglist.data.repositories.ShoppingRepository

@Suppress(names = ["UNCHECKED_CAST"])
class ShoppingViewModelFactory( // for passing some parameters for ViewModel we create this class
    private val repository: ShoppingRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T: ViewModel?> create(modelClass: Class<T>): T{
        return ShoppingViewModel(repository) as T
    }
}