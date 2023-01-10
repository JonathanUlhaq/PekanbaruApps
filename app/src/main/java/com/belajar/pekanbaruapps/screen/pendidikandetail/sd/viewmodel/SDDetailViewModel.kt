package com.belajar.pekanbaruapps.screen.pendidikandetail.sd.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.pekanbaruapps.model.SDModel
import com.belajar.pekanbaruapps.model.SMPModel
import com.belajar.pekanbaruapps.repositories.SDRepository
import com.belajar.pekanbaruapps.repositories.SMPRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SDDetailViewModel @Inject constructor(private val repo: SDRepository) :
    ViewModel() {

    private val _uiState = MutableStateFlow(SDModel())
    val uiState = _uiState.asStateFlow()

    fun deleteLatLong() {
        viewModelScope.launch {
            _uiState.value = SDModel(lat = 0.0, long = 0.0)
        }
    }

    fun getSDByName(name:String) {
        viewModelScope.launch {
            _uiState.value = repo.searchSD(name).first().first()
        }
    }


}