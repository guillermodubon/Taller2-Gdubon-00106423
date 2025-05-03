package com.pdmtaller2.GuillermoHernandez_00106423.ui.views.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.pdmtaller2.GuillermoHernandez_00106423.ui.views.components.RestaurantCard
import com.pdmtaller2.GuillermoHernandez_00106423.viewModels.RestaurantViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pdmtaller2.GuillermoHernandez_00106423.models.Category


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: RestaurantViewModel = viewModel(),
    navController: NavHostController
) {
    val allRestaurants by viewModel.restaurants.collectAsState()
    val categories: List<Category> = allRestaurants
        .flatMap { it.categories }
        .distinctBy { it.id }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("RESTAURANTES")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF131212)),
                modifier = Modifier.fillMaxWidth()
            )
        },
        containerColor = Color(0xFF131212)
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            categories.forEach { category ->
                item {
                    Text(
                        text = category.name,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
                item {
                    val inThisCategory = allRestaurants.filter { restaurant ->
                        category in restaurant.categories
                    }

                    LazyRow {
                        items(inThisCategory) { restaurant ->
                            RestaurantCard(
                                restaurant = restaurant,
                                onClick = {
                                    navController.navigate("menu/${restaurant.id}")
                                }
                            )
                        }
                    }
                }
            }
        }


    }
}