package com.belajar.pekanbaruapps.screen.magazine.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.model.HotelModel
import com.belajar.pekanbaruapps.model.MagazineModel
import com.belajar.pekanbaruapps.repositories.MagazineRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MagazineViewModel @Inject constructor(private val repo:MagazineRepository): ViewModel() {
    private val _uiState = MutableStateFlow<List<MagazineModel>>(emptyList())
    val uiState = _uiState.asStateFlow()

    fun getMagazine(search:String) {
        viewModelScope.launch {
            if (search.isEmpty()) {
                repo.getAllMagazine().collect{
                    _uiState.value = it
                }
            } else {
                repo.searchMagazine(search).collect {
                    _uiState.value = it
                }
            }
        }
    }

    fun insertMagazine(hotelModel: MagazineModel) {
        viewModelScope.launch {
            repo.insertMagazine(hotelModel)
        }
    }

    fun deleteMagazine(hotelModel: MagazineModel) {
        viewModelScope.launch {
            repo.deleteMagazine(hotelModel)
        }
    }

    val dummyData = listOf(
        MagazineModel(
            name = "Januari 2022",
            image = R.drawable.galeri_a
        ),
        MagazineModel(
            name = "Januari 2022",
            image = R.drawable.galeri_b
        ),
        MagazineModel(
            name = "Agustus 2022",
            image = R.drawable.galeri_c
        ),

        MagazineModel(
            name = "Desember 2021",
            image = R.drawable.galeri_d
        ),

        MagazineModel(
            name = "November 2021",
            image = R.drawable.galeri_e
        ),

        MagazineModel(
            name = "Oktober 2021",
            image = R.drawable.galeri_f
        )
    )

    fun insertData(list:List<MagazineModel>) =
        list.forEach {
            insertMagazine(it)
        }

    init {
        if(_uiState.value.isEmpty()) {
            insertData(dummyData)
        }
    }
}