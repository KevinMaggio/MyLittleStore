package com.example.mylittlestore.data.dto

data class ProductModel(
    val totalPages: Int,
    val page: Int,
    val products: List<Product>
) {
    data class Product(
        val id: Int,
        val name: String,
        val description: String,
        val createdAt: String,
        val updatedAt: String,
        val categories: List<Category>,
        val prices: List<Int>,
        val images: List<String>
    ) {
        data class Category(
            val id: Int?,
            val name: String
        )
    }
}
