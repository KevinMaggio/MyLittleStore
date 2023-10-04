package com.example.mylittlestore.data.repository

import com.example.mylittlestore.data.datasource.ProductDataSource
import com.example.mylittlestore.data.dto.ProductResponse
import com.example.mylittlestore.data.service.ApiResponse
import com.example.mylittlestore.data.service.ProductRepository

class ProductRepositoryImp(
    private val dataSource: ProductDataSource = ProductDataSource()
) : ProductRepository {

    override suspend fun getProducts(isInternetAvailable: Boolean): ApiResponse<ProductResponse> {
        return dataSource.getProducts(isInternetAvailable)
    }
}
