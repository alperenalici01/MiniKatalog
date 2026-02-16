package com.example.minikatalog.data

/**
 * Ürün modeli. JSON ve ekranlar arasında kullanılır.
 */
data class Product(
    val id: String,
    val name: String,
    val price: Double,
    val currency: String,
    val description: String,
    val imageResName: String,
    val category: String
)
