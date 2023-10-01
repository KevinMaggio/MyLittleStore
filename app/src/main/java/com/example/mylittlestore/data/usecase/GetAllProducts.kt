package com.example.mylittlestore.data.usecase

import android.content.Context
import com.example.mylittlestore.data.dto.ProductModel
import com.example.mylittlestore.data.mapper.toProductModel
import com.example.mylittlestore.data.repository.ProductRepositoryImp
import com.example.mylittlestore.data.service.Either
import com.example.mylittlestore.data.service.ProductRepository

class GetAllProducts(
    private val context: Context,
    private val productRepositoryImp: ProductRepository = ProductRepositoryImp(context)
) {

    suspend fun invoke(): Either<ProductModel, Exception> {
        return try {
            val result = productRepositoryImp.getProducts()
            Either.success(result.data.toProductModel())
        } catch (e: Exception) {
            Either.error(e)
        }
    }
}
