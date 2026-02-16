package com.example.minikatalog.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.minikatalog.ui.screens.CartScreen
import com.example.minikatalog.ui.screens.ProductDetailScreen
import com.example.minikatalog.ui.screens.ProductListScreen

@Composable
fun MiniKatalogNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Routes.PRODUCT_LIST
    ) {
        composable(Routes.PRODUCT_LIST) {
            ProductListScreen(
                onProductClick = { product ->
                    navController.navigate(Routes.productDetail(product.id))
                },
                onCartClick = {
                    navController.navigate(Routes.CART)
                }
            )
        }
        composable(
            route = Routes.PRODUCT_DETAIL,
            arguments = listOf(
                navArgument("productId") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            ProductDetailScreen(
                productId = productId,
                onBack = { navController.popBackStack() },
                onCartClick = { navController.navigate(Routes.CART) }
            )
        }
        composable(Routes.CART) {
            CartScreen(
                onBack = { navController.popBackStack() },
                onProductClick = { productId ->
                    navController.navigate(Routes.productDetail(productId))
                }
            )
        }
    }
}
