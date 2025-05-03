package com.pdmtaller2.GuillermoHernandez_00106423.models

import androidx.annotation.DrawableRes

data class Restaurant(
    val id: Int,
    val name: String,
    val description: String,
    @DrawableRes val imageUrl: Int,
    val categories: List<Category>,
    val menu: List<Dish> = emptyList()
)
