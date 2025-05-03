package com.pdmtaller2.GuillermoHernandez_00106423.consts

import com.pdmtaller2.GuillermoHernandez_00106423.models.Category

object CategoriesData {
    val ComidaRapida = Category(id = 1, name = "Comida Rapida")
    val Mariscos = Category(id = 2, name = "Mariscos")
    val ComidaMexicana = Category(id = 3, name = "Comida Mexicana")

    val allCategories = listOf(
        ComidaRapida,
        Mariscos,
        ComidaMexicana
    )
}