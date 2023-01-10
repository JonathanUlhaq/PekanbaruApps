package com.belajar.pekanbaruapps.screen.detailkesehatan.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.pekanbaruapps.model.BelanjaModel
import com.belajar.pekanbaruapps.model.KesehatanModel
import com.belajar.pekanbaruapps.repositories.BelanjaRepository
import com.belajar.pekanbaruapps.repositories.KesehatanRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailKesehatanViewModel @Inject constructor(private val repository: KesehatanRepository) :
    ViewModel() {

    private val _uiState = MutableStateFlow(KesehatanModel())
    val uiState = _uiState.asStateFlow()

    fun deleteLatLong() {
        viewModelScope.launch {
            _uiState.value = KesehatanModel(lat = 0.0, long = 0.0)
        }
    }

    fun getRestaurantByName(name: String) {
        viewModelScope.launch {
            _uiState.value = repository.searchKesehatan(name).first().first()
        }
    }
}