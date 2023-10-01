package com.example.mylittlestore.data.service

import com.example.mylittlestore.data.dto.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {

    @GET("/product")
    fun getProducts(): Response<ProductResponse>
}
