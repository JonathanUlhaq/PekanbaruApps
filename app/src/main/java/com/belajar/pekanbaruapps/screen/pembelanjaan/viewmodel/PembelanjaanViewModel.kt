package com.belajar.pekanbaruapps.screen.pembelanjaan.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.model.BelanjaModel
import com.belajar.pekanbaruapps.repositories.BelanjaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PembelanjaanViewModel @Inject constructor(private val repository: BelanjaRepository):ViewModel() {
    private val _uiState = MutableStateFlow<List<BelanjaModel>>(emptyList())
    val uiState = _uiState.asStateFlow()

    fun getAllBelanja(search:String) = viewModelScope.launch {
        if (search.isEmpty()) {
            repository.getAllBelanja().collect {
                _uiState.value = it
            }
        } else {
            repository.searchBelanja(search).collect {
                _uiState.value = it
            }
        }
    }

    fun insertBelanja(belanjaModel: BelanjaModel) = viewModelScope.launch {
        repository.insertBelanja(belanjaModel)
    }

    fun deleteBelanja(belanjaModel: BelanjaModel) = viewModelScope.launch {
        repository.deleteBelanja(belanjaModel)
    }

    fun dummyItems():List<BelanjaModel> =
        listOf(
            BelanjaModel(
                nama = "Sukaramai Trade Center",
                address = "Jl. Jend. Sudirman No.1, Sukaramai",
                openHour = "09:00 - 18:00 WIB",
                phone = "09:00 - 18:00 WIB",
                lat =0.5291163046816004,
                long = 101.44715829941781,
                about = "Sukaramai Trade Center (STC) merupakan pusat perdagangan terbesar dan terlengkap di Riau. Mengusung konsep one-stop-shopping, STC terdiri dari 1.918 tenant yang akan memanjakan konsumen; sebuah surga belanja di Pekanbaru.\n" +
                        "\n" +
                        "Pusat Perbelanjaan Sukaramai Tradecenter dilengkapi beberapa area yaitu Pusat Grosir, Fashion Muslim, Fashion & Aksesoris, Textile, Pusat Toko Emas, Food Court, Pusat Handphone, Lounge & Plaza Outdoor, Kosmetik, Ramayana, Cinema XXI, serta bazaar-bazaar yang berlokasi di Sukaramai Trade Center.",
                image = R.drawable.belanja_a
            ),
            BelanjaModel(
                nama = "Mal SKA",
                address = "Jl. Soekarno - Hatta No. 114",
                openHour = "09:00 - 18:00 WIB",
                phone = "09:00 - 18:00 WIB",
                lat =0.49960167016226703,
                long = 101.41849581516111,
                about = "Mal SKA merupakan pusat perdagangan terbesar dan terlengkap di Riau. Mengusung konsep one-stop-shopping, STC terdiri dari 1.918 tenant yang akan memanjakan konsumen; sebuah surga belanja di Pekanbaru.\n" +
                        "\n" +
                        "Pusat Perbelanjaan Sukaramai Tradecenter dilengkapi beberapa area yaitu Pusat Grosir, Fashion Muslim, Fashion & Aksesoris, Textile, Pusat Toko Emas, Food Court, Pusat Handphone, Lounge & Plaza Outdoor, Kosmetik, Ramayana, Cinema XXI, serta bazaar-bazaar yang berlokasi di Mal SKA.",
                image = R.drawable.belanja_b
            ),
            BelanjaModel(
                nama = "Mal Ciputra Seraya",
                address = "Jl. Riau No.58 Kel. Kampung Baru",
                openHour = "09:00 - 18:00 WIB",
                phone = "09:00 - 18:00 WIB",
                lat =0.5359913604045841,
                long = 101.43061335071648,
                about = "Mal Ciputra Seraya merupakan pusat perdagangan terbesar dan terlengkap di Riau. Mengusung konsep one-stop-shopping, STC terdiri dari 1.918 tenant yang akan memanjakan konsumen; sebuah surga belanja di Pekanbaru.\n" +
                        "\n" +
                        "Pusat Perbelanjaan Sukaramai Tradecenter dilengkapi beberapa area yaitu Pusat Grosir, Fashion Muslim, Fashion & Aksesoris, Textile, Pusat Toko Emas, Food Court, Pusat Handphone, Lounge & Plaza Outdoor, Kosmetik, Ramayana, Cinema XXI, serta bazaar-bazaar yang berlokasi di Mal Ciputra Seraya.",
                image = R.drawable.belanja_c
            ),
            BelanjaModel(
                nama = "Living World",
                address = "Jl. Soekarno - Hatta No. 114",
                openHour = "09:00 - 18:00 WIB",
                phone = "09:00 - 18:00 WIB",
                lat =0.5003288147801794,
                long = 101.42014887775422,
                about = "Living World merupakan pusat perdagangan terbesar dan terlengkap di Riau. Mengusung konsep one-stop-shopping, STC terdiri dari 1.918 tenant yang akan memanjakan konsumen; sebuah surga belanja di Pekanbaru.\n" +
                        "\n" +
                        "Pusat Perbelanjaan Sukaramai Tradecenter dilengkapi beberapa area yaitu Pusat Grosir, Fashion Muslim, Fashion & Aksesoris, Textile, Pusat Toko Emas, Food Court, Pusat Handphone, Lounge & Plaza Outdoor, Kosmetik, Ramayana, Cinema XXI, serta bazaar-bazaar yang berlokasi di Living World.",
                image = R.drawable.belanja_d
            ),
            BelanjaModel(
                nama = "Mal Pekanbaru",
                address = "Jl. Jendral Sudirman No.61",
                openHour = "09:00 - 18:00 WIB",
                phone = "09:00 - 18:00 WIB",
                lat =0.5319619382077153,
                long = 101.44797661389332,
                about = "Mal Pekanbaru merupakan pusat perdagangan terbesar dan terlengkap di Riau. Mengusung konsep one-stop-shopping, STC terdiri dari 1.918 tenant yang akan memanjakan konsumen; sebuah surga belanja di Pekanbaru.\n" +
                        "\n" +
                        "Pusat Perbelanjaan Sukaramai Tradecenter dilengkapi beberapa area yaitu Pusat Grosir, Fashion Muslim, Fashion & Aksesoris, Textile, Pusat Toko Emas, Food Court, Pusat Handphone, Lounge & Plaza Outdoor, Kosmetik, Ramayana, Cinema XXI, serta bazaar-bazaar yang berlokasi di Mal Pekanbaru.",
                image = R.drawable.belanja_e
            )
        )

    fun insertDummy(list:List<BelanjaModel>) {
        list.forEach {
            insertBelanja(it)
        }
    }

    init {
        if (_uiState.value.isEmpty()) {
            insertDummy(dummyItems())
        }
    }
}