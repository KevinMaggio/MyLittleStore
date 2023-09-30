package com.example.mylittlestore.data.datasource

import com.example.mylittlestore.data.dto.ProductResponse
import com.example.mylittlestore.data.service.ApiResponse
import com.example.mylittlestore.data.service.ProductServiceImp

class ProductDataSource (private val service : ProductServiceImp = ProductServiceImp()){

    suspend fun getProducts(connection: Boolean): ApiResponse<ProductResponse> {
        return if (connection){
            service.getProducts()
        }else{
            throw NoConnectionException("Not connection internet")
        }
    }

    class NoConnectionException(message: String) : Exception(message)
}