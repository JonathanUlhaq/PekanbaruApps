package com.belajar.pekanbaruapps.screen.galeri.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.model.GaleriModel
import com.belajar.pekanbaruapps.repositories.GaleriRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GaleriViewModel @Inject constructor(private val repo:GaleriRepository):ViewModel() {

    private val _uiState = MutableStateFlow<List<GaleriModel>>(emptyList())
    val uiState = _uiState.asStateFlow()

    fun getGaleri(search:String) {
        viewModelScope.launch {
            if (search.isEmpty()) {
                repo.getAllGaleri().collect{
                    _uiState.value = it
                }
            } else {
                repo.searchGaleri(search).collect {
                    _uiState.value = it
                }
            }
        }
    }

    fun insertGaleri(hotelModel: GaleriModel) {
        viewModelScope.launch {
            repo.insertGaleri(hotelModel)
        }
    }

    fun deleteGaleri(hotelModel: GaleriModel) {
        viewModelScope.launch {
            repo.deleteGaleri(hotelModel)
        }
    }

    val dummyGaleri = listOf(
        GaleriModel(
            "Pemko Pekanbaru Hadirkan Budaya Mengantar Penganten dan Perang Beras Kunyit Pada Apeksi 2022",
            "July 1, 2022",
            "400",
            "Pemerintah Kota (Pemko) Pekanbaru menghadirkan budaya dengan konsep Mengantar Penganten dan Perang Beras Kunyit pada pawai yang digelar di agenda Raker Komwil I Apeksi Tahun 2022, di Kota Medan, Provinsi Sumatera Utara. Pawai budaya ini diikuti oleh puluhan daerah peserta, yang digelar Jumat (1/7/2022).",
            R.drawable.galeri
        ),
        GaleriModel(
            "PJ Wali Kota Pekanbaru Muflihun Mengikuti Upacara HUT Kota Medan",
            "Januari 1, 2022",
            "400",
            "Pemerintah Kota (Pemko) Pekanbar menghadirkan budaya dengan konsep Mengantar Penganten dan Perang Beras Kunyit pada pawai yang digelar di agenda Raker Komwil I Apeksi Tahun 2022, di Kota Medan, Provinsi Sumatera Utara. Pawai budaya ini diikuti oleh puluhan daerah peserta, yang digelar Jumat (1/7/2022).",
            R.drawable.galeri_ab
        ),
        GaleriModel(
            "PJ Walikota Pekanbaru Ikuti Rakerwil I APEKSI di Medan",
            "July 1, 2022",
            "400",
            "Pemerintah Kota (Pemko) Pekanbaru menghadirkn budaya dengan konsep Mengantar Penganten dan Perang Beras Kunyit pada pawai yang digelar di agenda Raker Komwil I Apeksi Tahun 2022, di Kota Medan, Provinsi Sumatera Utara. Pawai budaya ini diikuti oleh puluhan daerah peserta, yang digelar Jumat (1/7/2022).",
            R.drawable.galeri_ba
        )
    )

    fun insertData(list:List<GaleriModel>) {
        list.forEach {
            insertGaleri(it)
        }
    }

    init {
        insertData(dummyGaleri)
    }

}