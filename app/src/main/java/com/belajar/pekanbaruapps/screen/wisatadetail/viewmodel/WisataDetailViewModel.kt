package com.belajar.pekanbaruapps.screen.wisatadetail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.pekanbaruapps.model.RestaurantModel
import com.belajar.pekanbaruapps.model.WisataModel
import com.belajar.pekanbaruapps.repositories.RestaurantRepository
import com.belajar.pekanbaruapps.repositories.WisataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WisataDetailViewModel @Inject constructor(private val repo: WisataRepository) :
    ViewModel() {

    private val _uiState = MutableStateFlow(WisataModel())
    val uiState = _uiState.asStateFlow()

    fun deleteLatLong() {
        viewModelScope.launch {
            _uiState.value = WisataModel(lat = 0.0, long = 0.0)
        }
    }

    fun getRestaurantByName(name:String) {
        viewModelScope.launch {
            _uiState.value = repo.getWisatabySearch(name).first().first()
        }
    }


}