package com.belajar.pekanbaruapps.screen.restaurant.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.model.RestaurantModel
import com.belajar.pekanbaruapps.repositories.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(private val repo: RestaurantRepository) :
    ViewModel() {
    private val _uiState = MutableStateFlow<List<RestaurantModel>>(emptyList())
    val uiState = _uiState.asStateFlow()

    fun dummyData(): List<RestaurantModel> = listOf(
        RestaurantModel(
            name = "Marugamen Udon",
            image = R.drawable.restaurant_a,
            address = "Jl. Jendral Sudirman, Bukit Raya",
            lat = 0.4986433005576568,
            long = 101.45529819113385,
            desc = "Marugame Udon adalah restoran yang menyajikan hidangan udon dan tempura yang digoreng khas Jepang di Indonesia. \n" +
                    "\n" +
                    "Semua resep yang digunakan merupakan resep asli dari Marugame Jepang, dimasak dengan menggunakan bahan-bahan berkualitas dan natural, dan diproses disetiap gerainya menggunakan tekhnik khusus dari Jepang.\n" +
                    "Selain itu, resep tersebut dikontrol dengan standard quality assurance yang ketat di setiap gerainya.",
            openHour = "10:00 - 21:00 WIB",
            phone = "+628 - 1121 - 2213",
            kecamatan = "Senapelan"
        ),
        RestaurantModel(
            name = "Restaurant Chilli Crab",
            image = R.drawable.restaurant_b,
            address = "Jl. Jendral Sudirman, Bukit Raya",
            lat = 0.47216792720269485,
            long = 101.45499667354015,
            desc = "Chilli Crab adalah restoran yang menyajikan hidangan udon dan tempura yang digoreng khas Jepang di Indonesia. \n" +
                    "\n" +
                    "Semua resep yang digunakan merupakan resep asli dari Marugame Jepang, dimasak dengan menggunakan bahan-bahan berkualitas dan natural, dan diproses disetiap gerainya menggunakan tekhnik khusus dari Jepang.\n" +
                    "Selain itu, resep tersebut dikontrol dengan standard quality assurance yang ketat di setiap gerainya.",
            openHour = "10:00 - 21:00 WIB",
            phone = "+628 - 1121 - 1213",
            kecamatan = "Bukit Raya"
        ),
        RestaurantModel(
            name = "Kedai Kopi Alun 08",
            image = R.drawable.restaurant_c,
            address = "Jl. Juanda Pekanbaru, Lima Puluh",
            lat = 0.5357565132358465,
            long = 101.4451149681395,
            desc = "Kedai Kopi Alun 08 adalah restoran yang menyajikan hidangan udon dan tempura yang digoreng khas Jepang di Indonesia. \n" +
                    "\n" +
                    "Semua resep yang digunakan merupakan resep asli dari Marugame Jepang, dimasak dengan menggunakan bahan-bahan berkualitas dan natural, dan diproses disetiap gerainya menggunakan tekhnik khusus dari Jepang.\n" +
                    "Selain itu, resep tersebut dikontrol dengan standard quality assurance yang ketat di setiap gerainya.",
            openHour = "10:00 - 21:00 WIB",
            phone = "+628 - 1121 - 1223",
            kecamatan = "Sail"
        ),
        RestaurantModel(
            name = "Abege Cafe Pool & Resto",
            image = R.drawable.restaurant_d,
            address = "Jl. Arifin Ahmad, Marpoyan Damai",
            lat = 0.47606357747466344,
            long = 101.42688290092909,
            desc = "Abege Cafe Pool & Resto adalah restoran yang menyajikan hidangan udon dan tempura yang digoreng khas Jepang di Indonesia. \n" +
                    "\n" +
                    "Semua resep yang digunakan merupakan resep asli dari Marugame Jepang, dimasak dengan menggunakan bahan-bahan berkualitas dan natural, dan diproses disetiap gerainya menggunakan tekhnik khusus dari Jepang.\n" +
                    "Selain itu, resep tersebut dikontrol dengan standard quality assurance yang ketat di setiap gerainya.",
            openHour = "10:00 - 21:00 WIB",
            phone = "+628 - 1121 - 5223",
            kecamatan = "Tampan"
        ),
        RestaurantModel(
            name = "Teras Kayu Resto Sudirman",
            image = R.drawable.restaurant_e,
            address = "Jl. Arifin Ahmad, Marpoyan Damai",
            lat = 0.4714808356088837,
            long = 101.45484765359205,
            desc = "Teras Kayu Resto Sudirman adalah restoran yang menyajikan hidangan udon dan tempura yang digoreng khas Jepang di Indonesia. \n" +
                    "\n" +
                    "Semua resep yang digunakan merupakan resep asli dari Marugame Jepang, dimasak dengan menggunakan bahan-bahan berkualitas dan natural, dan diproses disetiap gerainya menggunakan tekhnik khusus dari Jepang.\n" +
                    "Selain itu, resep tersebut dikontrol dengan standard quality assurance yang ketat di setiap gerainya.",
            openHour = "10:00 - 21:00 WIB",
            phone = "+628 - 1121 - 5223",
            kecamatan = "Pekanbaru Kota"
        )
    )

    fun getAllRestaurant(search:String) {
        viewModelScope.launch {

            if (search.isEmpty()) {
                repo.getAllRestaurant().distinctUntilChanged().collect { list ->
                    if (!list.isEmpty()) {
                        _uiState.value = list
                    }
                }
            } else {
                repo.searchRestaurant(search).distinctUntilChanged().collect {
                    if (!it.isEmpty()) {
                        _uiState.value = it
                    }
                }
            }


        }
    }

    fun insertRestaurant(restaurantModel: RestaurantModel) = viewModelScope.launch {
        repo.insertRestaurant(restaurantModel)
    }

    fun deleteRestaurant(restaurantModel: RestaurantModel) = viewModelScope.launch {
        repo.deleteRestaurant(restaurantModel)
    }

    fun insertDummyData(
        list: List<RestaurantModel>
    ) {
        list.forEach {
            insertRestaurant(it)
        }
    }

    init {
            insertDummyData(dummyData())
    }

}