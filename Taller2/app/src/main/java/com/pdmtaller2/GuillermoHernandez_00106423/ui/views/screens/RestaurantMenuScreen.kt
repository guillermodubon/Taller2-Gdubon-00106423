package com.pdmtaller2.GuillermoHernandez_00106423.ui.views.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.pdmtaller2.GuillermoHernandez_00106423.models.Restaurant
import com.pdmtaller2.GuillermoHernandez_00106423.ui.views.components.CustomSearchBar
import com.pdmtaller2.GuillermoHernandez_00106423.ui.views.components.DishCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantMenuScreen(
    restaurant: Restaurant,
    navController: NavHostController
) {
    val context = LocalContext.current
    var query by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val filtered = restaurant.menu.filter {
        it.name.contains(query, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(restaurant.name)
                    }
                },
                navigationIcon = {
                    IconButton({ navController.popBackStack() }) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    Spacer(modifier = Modifier.size(48.dp))
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(
                        0xFF383131
                    )
                )
            )
        },
        containerColor = Color(0xFF131212)
    ) { paddingValues ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            CustomSearchBar(
                query = query,
                onQueryChange = { query = it },
                expanded = expanded,
                onExpandedChange = { expanded = it },
                placeHolder = "Platillos de ${restaurant.name}"
            )

            Text(
                text = restaurant.description,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            Spacer(Modifier.height(8.dp))

            LazyColumn(Modifier.fillMaxSize()) {
                items(filtered, key = { it.id }) { dish ->
                    DishCard(
                        dish = dish,
                        context = context
                    )
                }
                if (filtered.isEmpty()) {
                    item {
                        Text(
                            "No se encontraron platillos",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(24.dp),
                            textAlign = TextAlign.Center,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    }
}
