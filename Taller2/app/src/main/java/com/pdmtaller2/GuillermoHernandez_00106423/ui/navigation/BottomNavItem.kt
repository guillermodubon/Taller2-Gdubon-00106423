package com.pdmtaller2.GuillermoHernandez_00106423.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object Restaurants : BottomNavItem("restaurants", Icons.Default.Home, "Restaurantes")
    object Search : BottomNavItem("search", Icons.Default.Search, "Busqueda")
    object Orders : BottomNavItem("orders", Icons.Default.ShoppingCart, "Mis ordenes")
}

val bottomNavItems = listOf(
    BottomNavItem.Restaurants,
    BottomNavItem.Search,
    BottomNavItem.Orders
)