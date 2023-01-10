package com.belajar.pekanbaruapps.screen.detailhotel.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.pekanbaruapps.model.HotelModel
import com.belajar.pekanbaruapps.repositories.DetailHotelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailHotelViewModel @Inject constructor(private val repo:DetailHotelRepository) :ViewModel() {
    private val _uiState = MutableStateFlow(HotelModel())
    val uiState = _uiState.asStateFlow()

    fun deleteList() {
        viewModelScope.launch {
            _uiState.value = HotelModel(lat = 0.0, long = 0.0)
        }
    }

    fun getHotelbyName(name:String) {
        viewModelScope.launch {
           repo.getHotelByName(name).distinctUntilChanged().collect{
               _uiState.value = it
           }
        }
    }
}