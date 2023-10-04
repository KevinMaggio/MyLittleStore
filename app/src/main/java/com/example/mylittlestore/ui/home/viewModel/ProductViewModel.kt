package com.example.mylittlestore.ui.home.viewModel

import androidx.lifecycle.ViewModel
import com.example.mylittlestore.data.dto.ProductModel
import com.example.mylittlestore.data.service.Either
import com.example.mylittlestore.data.usecase.ProductUseCase
import com.example.mylittlestore.utils.orEmpty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ProductViewModel(
    private val useCase: ProductUseCase = ProductUseCase()
) : ViewModel() {

    val state = MutableStateFlow<ProductViewModelEvent>(ProductViewModelEvent.StateLoading)

    fun getProducts(isInternetAvailable: Boolean) {
        CoroutineScope(Dispatchers.IO).launch {
            val result = useCase.getAllProducts.invoke(isInternetAvailable)
            ProductViewModelEvent.StateLoading
            handledHomeInformation(result)
        }
    }

    private fun handledHomeInformation(data: Either<ProductModel, Exception>) {
        when (data) {
            is Either.Success -> {
                state.value = ProductViewModelEvent.StateSuccess(data.value)
            }

            is Either.Error -> {
                state.value = ProductViewModelEvent.StateError(data.error.message.orEmpty())
            }
        }
    }
}
