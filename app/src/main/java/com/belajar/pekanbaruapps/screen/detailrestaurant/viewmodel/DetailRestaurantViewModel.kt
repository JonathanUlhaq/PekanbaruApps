package com.belajar.pekanbaruapps.screen.detailrestaurant.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.pekanbaruapps.model.RestaurantModel
import com.belajar.pekanbaruapps.repositories.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailRestaurantViewModel @Inject constructor(private val repo: RestaurantRepository) :
    ViewModel() {

    private val _uiState = MutableStateFlow(RestaurantModel())
    val uiState = _uiState.asStateFlow()

    fun deleteLatLong() {
        viewModelScope.launch {
            _uiState.value = RestaurantModel(lat = 0.0, long = 0.0)
        }
    }

    fun getRestaurantByName(name:String) {
        viewModelScope.launch {
            _uiState.value = repo.searchRestaurant(name).first().first()
        }
    }


}