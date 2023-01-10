package com.belajar.pekanbaruapps.screen.pengumuman.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.model.PengumumanModel
import com.belajar.pekanbaruapps.repositories.PengumumanRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PengumumanViewModel @Inject constructor(private val repo:PengumumanRepository):ViewModel() {

    private val _uiState = MutableStateFlow<List<PengumumanModel>>(emptyList())
    val uiState = _uiState.asStateFlow()

    fun getPengumuman(search:String) {
        viewModelScope.launch {
            if (search.isEmpty()) {
                repo.getAllPengumuman().collect{
                    _uiState.value = it
                }
            } else {
                repo.searchPengumuman(search).collect {
                    _uiState.value = it
                }
            }
        }
    }

    fun insertPengumuman(hotelModel: PengumumanModel) {
        viewModelScope.launch {
            repo.insertPengumuman(hotelModel)
        }
    }

    fun deletePengumuman(hotelModel: PengumumanModel) {
        viewModelScope.launch {
            repo.deletePengumuman(hotelModel)
        }
    }

    val dummyData = listOf(
        PengumumanModel(
            name = "Pengumuman Tentang Perpanjangan Masa Pendaftaran Kerjasama Penyebarluasan Informasi Pemerintah Kota Pekanbaru Melalui Media Masa",
            image = R.drawable.pengumuman_gambar,
            date = "Januari 2, 2023",
            view = "200"
        ),
        PengumumanModel(
            name = "Hasil Analisis Pengukuran Data Stunting Kota Pekanbaru Tahun 2022",
            image = R.drawable.pengumuman_gambar,
            date = "Januari 2, 2023",
            view = "200"
        ),

        PengumumanModel(
            name = "Pengumuman Tentang Pembukaan Kerjasama Penyebarluasan Informasi Pemerintah Kota Pekanbaru Melalui Media Massa",
            image = R.drawable.pengumuman_gambar,
            date = "Januari 2, 2023",
            view = "200"
        ),
    )

    fun insertDummy(list:List<PengumumanModel>) {
        list.forEach {
            insertPengumuman(it)
        }
    }

    init {
        if (_uiState.value.isEmpty()) {
            insertDummy(dummyData)
        }
    }
}