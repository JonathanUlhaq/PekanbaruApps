package com.belajar.pekanbaruapps.screen.detailperbelanjaan.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.pekanbaruapps.model.BelanjaModel
import com.belajar.pekanbaruapps.model.RestaurantModel
import com.belajar.pekanbaruapps.repositories.BelanjaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailPerbelanjaanViewModel @Inject constructor(private val repository: BelanjaRepository) :
    ViewModel() {

    private val _uiState = MutableStateFlow(BelanjaModel())
    val uiState = _uiState.asStateFlow()

    fun deleteLatLong() {
        viewModelScope.launch {
            _uiState.value = BelanjaModel(lat = 0.0, long = 0.0)
        }
    }

    fun getRestaurantByName(name:String) {
        viewModelScope.launch {
            _uiState.value = repository.searchBelanja(name).first().first()
        }
    }
}