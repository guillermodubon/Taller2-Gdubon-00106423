package com.pdmtaller2.GuillermoHernandez_00106423.ui.views.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.pdmtaller2.GuillermoHernandez_00106423.ui.views.components.CustomSearchBar
import com.pdmtaller2.GuillermoHernandez_00106423.ui.views.components.RestaurantCard
import com.pdmtaller2.GuillermoHernandez_00106423.viewModels.RestaurantViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavHostController) {
    val viewModel: RestaurantViewModel = viewModel()
    val allRestaurants by viewModel.restaurants.collectAsState()

    var query by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val queryLowerCase = query.trim().lowercase()
    val nameMatches = if (queryLowerCase.isEmpty()) emptyList() else {
        allRestaurants.filter { it.name.lowercase().contains(queryLowerCase) }
    }

    val dishMatches = if (queryLowerCase.isEmpty()) emptyList() else {
        allRestaurants.filter { rest ->
            rest.menu.any { it.name.lowercase().contains(queryLowerCase) }
        }.minus(nameMatches)
    }

    val categoryMatches = if (queryLowerCase.isEmpty()) emptyList() else {
        allRestaurants.filter { rest ->
            rest.categories.any { category ->
                category.name.lowercase().contains(queryLowerCase)
            }
        }.minus(nameMatches).minus(dishMatches)
    }

    val results = nameMatches + dishMatches + categoryMatches

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Busqueda")
                    }

                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF131212))
            )
        },
        containerColor = Color(0xFF131212)
    ) { padding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            CustomSearchBar(
                query = query,
                onQueryChange = {
                    query = it
                },
                expanded = expanded,
                onExpandedChange = { expanded = it },
                placeHolder = "Restaurantes, Categorías, Platillos"
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (results.isEmpty() && queryLowerCase.isNotEmpty()) {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "No se encontraron restaurantes",
                                modifier = Modifier
                                    .padding(16.dp),
                                fontWeight = FontWeight.Medium,
                                color = Color.Gray,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                } else {
                    items(results, key = { it.id }) { restaurant ->
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