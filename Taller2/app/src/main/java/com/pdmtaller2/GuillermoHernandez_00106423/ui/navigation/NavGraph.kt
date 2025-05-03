package com.pdmtaller2.GuillermoHernandez_00106423.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pdmtaller2.GuillermoHernandez_00106423.ui.views.screens.MainScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.pdmtaller2.GuillermoHernandez_00106423.ui.views.screens.OrdersScreen
import com.pdmtaller2.GuillermoHernandez_00106423.ui.views.screens.RestaurantMenuScreen
import com.pdmtaller2.GuillermoHernandez_00106423.ui.views.screens.SearchScreen
import com.pdmtaller2.GuillermoHernandez_00106423.viewModels.RestaurantViewModel


@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    val viewModel: RestaurantViewModel = viewModel()
    val allRestaurants by viewModel.restaurants.collectAsState()

    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(
                navController = navController,
                startDestination = BottomNavItem.Restaurants.route
            ) {

                navigation(
                    startDestination = "main",
                    route = BottomNavItem.Restaurants.route
                ) {
                    composable("main") {
                        MainScreen(navController = navController)
                    }
                    composable(
                        route = "menu/{restaurantId}",
                        arguments = listOf(navArgument("restaurantId") {
                            type = NavType.IntType
                        })
                    ) { backStackEntry ->
                        val id = backStackEntry.arguments?.getInt("restaurantId")
                        val restaurant = allRestaurants.firstOrNull { it.id == id }
                        if (restaurant != null) {
                            RestaurantMenuScreen(
                                restaurant = restaurant,
                                navController = navController
                            )
                        } else {

                            LaunchedEffect(Unit) {
                                navController.popBackStack()
                            }
                        }
                    }
                }

                composable(BottomNavItem.Search.route) {
                    SearchScreen(navController)
                }

                composable(BottomNavItem.Orders.route) {
                    OrdersScreen()
                }
            }
        }
    }
}



