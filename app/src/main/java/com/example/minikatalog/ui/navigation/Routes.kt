package com.example.minikatalog.ui.navigation

/**
 * Uygulama sayfa rotaları.
 */
object Routes {
    const val PRODUCT_LIST = "product_list"
    const val PRODUCT_DETAIL = "product_detail/{productId}"
    const val CART = "cart"

    fun productDetail(productId: String) = "product_detail/$productId"
}
