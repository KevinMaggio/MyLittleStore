package com.example.mylittlestore.data.datasource

import com.example.mylittlestore.data.dto.ProductResponse
import com.example.mylittlestore.data.service.ApiResponse
import com.example.mylittlestore.data.service.ProductServiceImp
import com.example.mylittlestore.utils.Constants.ERROR_CONNECTION

class ProductDataSource (private val service : ProductServiceImp = ProductServiceImp()){

    suspend fun getProducts(connection: Boolean): ApiResponse<ProductResponse> {
        return if (connection){
            service.getProducts()
        }else{
            throw ErrorException(ERROR_CONNECTION)
        }
    }

    class ErrorException(message: String) : Exception(message)
}