package com.example.mylittlestore.data.service

import com.example.mylittlestore.data.dto.ProductResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductServiceImp {

    private val serviceImp = providerApiImplement()


    suspend fun getProducts(): ApiResponse<ProductResponse> {
        val response = serviceImp?.getProducts()
        return ApiResponse.create(response?.code() ?: 0, response?.body(), response?.message())
    }

    private fun providerApiImplement(): ProductService? {
        return providerRetrofit()?.create(ProductService::class.java)
    }

    private fun providerRetrofit(): Retrofit? {
        return Retrofit.Builder()
            .baseUrl("https://stoplight.io/mocks/refactoringlife/refactoringlife/218091855")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
