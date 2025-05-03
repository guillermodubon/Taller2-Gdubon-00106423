package com.pdmtaller2.GuillermoHernandez_00106423.viewModels

import androidx.lifecycle.ViewModel
import com.pdmtaller2.GuillermoHernandez_00106423.R
import com.pdmtaller2.GuillermoHernandez_00106423.consts.CategoriesData.ComidaMexicana
import com.pdmtaller2.GuillermoHernandez_00106423.consts.CategoriesData.ComidaRapida
import com.pdmtaller2.GuillermoHernandez_00106423.consts.CategoriesData.Mariscos
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.AlitasBuffalo
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.ArrozCalamares
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.BrochetasCamaron
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.CazuelaMariscos
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.CevichePescado
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.ChilaquilesRojos
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.ChilesEnNogada
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.CoctelCamarones
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.CuatroQuesos
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.DobleBaconBBQ
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.EnchiladasVerdes
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.HamburguesaClásica
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.MargheritaClásica
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.MejillonesVapor
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.MolePoblano
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.PaellaMariscos
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.PepperoniClasica
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.PolloAjillo
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.PolloBrasa
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.PozoleRojo
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.PulpoGallega
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.QuesadillasFlor
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.SopaTortilla
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.TacosAlPastor
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.TacosPescado
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.TostadasCeviche
import com.pdmtaller2.GuillermoHernandez_00106423.consts.DishesData.VeggieDeluxe
import com.pdmtaller2.GuillermoHernandez_00106423.models.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class RestaurantViewModel : ViewModel() {

    private val _restaurants = MutableStateFlow<List<Restaurant>>(emptyList())
    val restaurants: StateFlow<List<Restaurant>> = _restaurants

    init {
        _restaurants.value = listOf(

            Restaurant(
                id = 1,
                name = "Divine Pizza",
                description = "Las pizzas más divinas de la tierra.",
                imageUrl = R.drawable.divine_pizza,
                categories = listOf(ComidaRapida),
                menu = listOf(
                    MargheritaClásica,
                    CuatroQuesos,
                    PepperoniClasica
                )
            ),

            Restaurant(
                id = 2,
                name = "Burger House",
                description = "Las mejores hamburguesas artesanales.",
                imageUrl = R.drawable.burger_house,
                categories = listOf(ComidaRapida),
                menu = listOf(
                    HamburguesaClásica,
                    DobleBaconBBQ,
                    VeggieDeluxe
                )
            ),

            Restaurant(
                id = 3,
                name = "Chicken grill",
                description = "Los pollos mas poderosos del universo.",
                imageUrl = R.drawable.chicken_grill,
                categories = listOf(ComidaRapida),
                menu = listOf(
                    PolloBrasa,
                    AlitasBuffalo,
                    PolloAjillo
                )
            ),

            Restaurant(
                id = 4,
                name = "Mariscos El Puerto",
                description = "Lo mejor del mar directo a tu mesa.",
                imageUrl = R.drawable.mariscos_el_puerto,
                categories = listOf(Mariscos),
                menu = listOf(
                    CevichePescado,
                    CoctelCamarones,
                    PulpoGallega
                )
            ),
            Restaurant(
                id = 5,
                name = "Los mariscos",
                description = "Arroces y mariscos con tradición.",
                imageUrl = R.drawable.los_mariscos,
                categories = listOf(Mariscos),
                menu = listOf(
                    PaellaMariscos,
                    CazuelaMariscos,
                    TacosPescado
                )
            ),
            Restaurant(
                id = 6,
                name = "El Rincón Marino",
                description = "Sabores del océano en cada bocado.",
                imageUrl = R.drawable.el_rincon_marino,
                categories = listOf(Mariscos),
                menu = listOf(
                    ArrozCalamares,
                    MejillonesVapor,
                    BrochetasCamaron
                )
            ),

            Restaurant(
                id = 7,
                name = "Tacos mi pueblo",
                description = "Auténtica cocina mexicana.",
                imageUrl = R.drawable.tacos_mi_pueblo,
                categories = listOf(ComidaRapida, ComidaMexicana),
                menu = listOf(
                    TacosAlPastor,
                    ChilesEnNogada,
                    EnchiladasVerdes
                )
            ),
            Restaurant(
                id = 8,
                name = "La Tradición Mexicana",
                description = "Platos clásicos con toque casero.",
                imageUrl = R.drawable.la_tradicion_mexicana,
                categories = listOf(ComidaMexicana),
                menu = listOf(
                    PozoleRojo,
                    MolePoblano,
                    QuesadillasFlor
                )
            ),
            Restaurant(
                id = 9,
                name = "Sabor Mexicano",
                description = "Antojitos mexicanos para compartir.",
                imageUrl = R.drawable.sabor_mexicano,
                categories = listOf(ComidaMexicana),
                menu = listOf(
                    SopaTortilla,
                    TostadasCeviche,
                    ChilaquilesRojos
                )
            )
        )
    }
}