package com.belajar.pekanbaruapps.screen.pendidikandetail.smp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.pekanbaruapps.model.RestaurantModel
import com.belajar.pekanbaruapps.model.SMPModel
import com.belajar.pekanbaruapps.repositories.RestaurantRepository
import com.belajar.pekanbaruapps.repositories.SMPRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SMPDetailViewModel @Inject constructor(private val repo: SMPRepository) :
    ViewModel() {

    private val _uiState = MutableStateFlow(SMPModel())
    val uiState = _uiState.asStateFlow()

    fun deleteLatLong() {
        viewModelScope.launch {
            _uiState.value = SMPModel(lat = 0.0, long = 0.0)
        }
    }

    fun getSMPByName(name:String) {
        viewModelScope.launch {
            _uiState.value = repo.searchSMP(name).first().first()
        }
    }


}