package com.example.mylittlestore.ui.home.viewModel

import com.example.mylittlestore.data.dto.ProductModel

sealed class ProductViewModelEvent {
    data class StateSuccess(val data: ProductModel): ProductViewModelEvent()
    object StateLoading : ProductViewModelEvent()
    data class StateError(val message: String) : ProductViewModelEvent()
}