package com.example.mylittlestore.data.mapper

import com.example.mylittlestore.data.dto.ProductModel
import com.example.mylittlestore.data.dto.ProductResponse
import com.example.mylittlestore.utils.orEmpty

fun ProductResponse?.toProductModel(): ProductModel {
    return ProductModel(
        totalPages = this?.data?.totalPages ?: 0,
        page = this?.data?.page ?: 0,
        products = this.toProducts()
    )
}

private fun ProductResponse?.toProducts(): List<ProductModel.Product> {
    val products = mutableListOf<ProductModel.Product>()
    this?.data?.products?.forEach { product ->
        products.add(
            ProductModel.Product(
                id = product.id ?: 0,
                name = product.name.orEmpty(),
                description = product.description.orEmpty(),
                createdAt = product.createdAt.orEmpty(),
                updatedAt = product.updatedAt.orEmpty(),
                categories = product.categories?.map { it.toCategory() } ?: emptyList(),
                prices = product.prices?.map { it.value ?: 0 } ?: emptyList(),
                images = product.images?.map { it.value.orEmpty() } ?: emptyList()
            )
        )
    }
    return products
}

private fun ProductResponse.ProductData.Product.Category.toCategory(): ProductModel.Product.Category {
    return ProductModel.Product.Category(
        id = this.id,
        name = this.name
    )
}
