package com.example.minikatalog.data

import android.content.Context
import org.json.JSONArray
import java.io.IOException

/**
 * Ürün verisini assets/products.json dosyasından yükler.
 */
object ProductsRepository {

    fun getProducts(context: Context): List<Product> {
        return try {
            val json = context.assets.open("products.json")
                .bufferedReader()
                .use { it.readText() }
            parseProducts(json)
        } catch (e: IOException) {
            emptyList()
        }
    }

    private fun parseProducts(json: String): List<Product> {
        val list = mutableListOf<Product>()
        val array = JSONArray(json)
        for (i in 0 until array.length()) {
            val obj = array.getJSONObject(i)
            list.add(
                Product(
                    id = obj.getString("id"),
                    name = obj.getString("name"),
                    price = obj.getDouble("price"),
                    currency = obj.getString("currency"),
                    description = obj.getString("description"),
                    imageResName = obj.getString("imageResName"),
                    category = obj.getString("category")
                )
            )
        }
        return list
    }

    fun getProductById(context: Context, id: String): Product? {
        return getProducts(context).find { it.id == id }
    }
}
