package com.example.minikatalog.data

import androidx.compose.runtime.mutableStateListOf

/**
 * Basit sepet state'i. Ürün id'leri tutar; UI recompose için mutableStateListOf.
 */
object Cart {
    private val _productIds = mutableStateListOf<String>()
    val productIds: List<String> get() = _productIds

    fun add(productId: String) {
        if (productId !in _productIds) _productIds.add(productId)
    }

    fun remove(productId: String) {
        _productIds.remove(productId)
    }

    fun contains(productId: String): Boolean = productId in _productIds

    val count: Int get() = _productIds.size
}
