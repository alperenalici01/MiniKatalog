package com.example.minikatalog.data

import androidx.compose.runtime.mutableStateMapOf

/**
 * Sepet yönetimi için basit bir Singleton state yöneticisi.
 * Gerçek bir uygulamada bu bir ViewModel içinde olmalıydı, 
 * ancak bu mini projede global state paylaşımı için pratik bir yöntemdir.
 */
object CartManager {
    // Ürün ID'sini ve miktarını tutar
    private val _items = mutableStateMapOf<String, Int>()
    val items: Map<String, Int> get() = _items

    fun addToCart(productId: String) {
        val current = _items[productId] ?: 0
        _items[productId] = current + 1
    }

    fun removeFromCart(productId: String) {
        val current = _items[productId] ?: 0
        if (current > 1) {
            _items[productId] = current - 1
        } else {
            _items.remove(productId)
        }
    }

    fun getTotalItemCount(): Int {
        return _items.values.sum()
    }
    
    fun clearCart() {
        _items.clear()
    }
}
