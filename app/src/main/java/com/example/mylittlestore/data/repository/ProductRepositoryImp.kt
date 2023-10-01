package com.example.mylittlestore.data.repository

import android.content.Context
import com.example.mylittlestore.data.datasource.ProductDataSource
import com.example.mylittlestore.data.dto.ProductResponse
import com.example.mylittlestore.data.service.ApiResponse
import com.example.mylittlestore.data.service.ProductRepository
import com.example.mylittlestore.utils.isInternetAvailable

class ProductRepositoryImp(
    private val context: Context,
    private val dataSource: ProductDataSource = ProductDataSource()
): ProductRepository {

    override suspend fun getProducts(): ApiResponse<ProductResponse> {
        return dataSource.getProducts(isInternetAvailable(context))
    }
}
