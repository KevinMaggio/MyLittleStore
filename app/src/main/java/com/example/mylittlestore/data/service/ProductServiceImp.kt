package com.example.mylittlestore.data.service

import com.example.mylittlestore.data.dto.ProductResponse
import com.example.mylittlestore.utils.Constants.CODE_GENERIC
import com.example.mylittlestore.utils.Constants.TIME_OUT
import java.io.IOException

class ProductServiceImp {
    private val serviceImp: ProductService = RetrofitClient.getInstance()

    suspend fun getProducts(): ApiResponse<ProductResponse> {
        return try {
            val response = serviceImp.getProducts()
            ApiResponse.create(response.code(), response.body(), response.message())
        } catch (e: IOException) {
            ApiResponse.create(TIME_OUT, null, null)
        } catch (e: Exception) {
            ApiResponse.create(CODE_GENERIC, null, null)
        }
    }
}
