package com.example.mylittlestore.data.dto

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("data")
    val data: ProductData
) {
    data class ProductData(
        @SerializedName("totalElements")
        val totalElements: Int?,
        @SerializedName("totalPages")
        val totalPages: Int?,
        @SerializedName("size")
        val size: Int?,
        @SerializedName("page")
        val page: Int?,
        @SerializedName("products")
        val products: List<Product>?
    ) {
        data class Product(
            @SerializedName("id")
            val id: Int?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("description")
            val description: String?,
            @SerializedName("createdAt")
            val createdAt: String?,
            @SerializedName("updatedAt")
            val updatedAt: String?,
            @SerializedName("categories")
            val categories: List<Category>?,
            @SerializedName("Prices")
            val prices: List<Price>?,
            @SerializedName("images")
            val images: List<Image>?
        ) {
            data class Image(
                @SerializedName("link")
                val value: String?,
                @SerializedName("provider")
                val provider: String?,
                @SerializedName("id")
                val id: Int?
            )

            data class Price(
                @SerializedName("id")
                val id: Int?,
                @SerializedName("value")
                val value: Int?
            )

            data class Category(
                @SerializedName("id")
                val id: Int?,
                @SerializedName("name")
                val name: String
            )
        }
    }
}
