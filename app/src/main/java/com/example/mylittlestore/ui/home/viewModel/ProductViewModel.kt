package com.example.mylittlestore.ui.home.viewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mylittlestore.data.usecase.ProductUseCase

class ProductViewModel(context: Context,
    private val useCase: ProductUseCase = ProductUseCase(context)
): ViewModel() {

    val data = MutableLiveData<ProductViewModelEvent>()

    suspend fun getProducts(){
        val result = useCase.getAllProducts.invoke()
        ProductViewModelEvent.StateLoading
    }
}