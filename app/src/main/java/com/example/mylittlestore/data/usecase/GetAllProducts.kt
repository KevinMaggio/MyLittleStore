package com.example.mylittlestore.data.usecase

import com.example.mylittlestore.data.datasource.ProductDataSource
import com.example.mylittlestore.data.dto.ProductModel
import com.example.mylittlestore.data.mapper.toProductModel
import com.example.mylittlestore.data.repository.ProductRepositoryImp
import com.example.mylittlestore.data.service.ApiResponse
import com.example.mylittlestore.data.service.Either
import com.example.mylittlestore.data.service.ProductRepository

class GetAllProducts(
    private val productRepositoryImp: ProductRepository = ProductRepositoryImp()
) {

    suspend fun invoke(isInternetAvailable: Boolean): Either<ProductModel, Exception> {
        return try {
            val result = productRepositoryImp.getProducts(isInternetAvailable)
            if (result.status == ApiResponse.Companion.Status.SUCCESS) {
                Either.success(result.data.toProductModel())
            } else {
                Either.error(ProductDataSource.ErrorException(result.message))
            }
        } catch (e: Exception) {
            Either.error(e)
        }
    }
}
