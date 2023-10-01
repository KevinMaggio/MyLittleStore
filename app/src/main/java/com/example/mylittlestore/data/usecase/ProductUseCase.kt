package com.example.mylittlestore.data.usecase

import android.content.Context

class ProductUseCase(private val context: Context) {
    val getAllProducts : GetAllProducts = GetAllProducts(context)
}