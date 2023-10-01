package com.example.mylittlestore.data.service

import com.example.mylittlestore.data.dto.ProductResponse

interface ProductRepository {

    suspend fun getProducts(): ApiResponse<ProductResponse>
}
