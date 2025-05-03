package com.pdmtaller2.GuillermoHernandez_00106423.models

import androidx.annotation.DrawableRes

data class Dish(
    val id: Int,
    val name: String,
    val description: String,
    @DrawableRes val imageRes: Int
)
