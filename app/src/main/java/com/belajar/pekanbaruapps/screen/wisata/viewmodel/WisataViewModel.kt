package com.belajar.pekanbaruapps.screen.wisata.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.model.WisataModel
import com.belajar.pekanbaruapps.repositories.WisataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WisataViewModel @Inject constructor(private val repo:WisataRepository):ViewModel() {
    private val _uiState = MutableStateFlow<List<WisataModel>>(emptyList())
    val uiState = _uiState.asStateFlow()

    fun getAllWisata(search:String) = viewModelScope.launch {
        if (search.isEmpty()) {
            repo.getAllWisata().distinctUntilChanged().collect {
                _uiState.value = it
            }
        } else {
            repo.getWisatabySearch(search).distinctUntilChanged().collect{
                _uiState.value = it
            }
        }
    }

    fun insertWisata(wisataModel: WisataModel) = viewModelScope.launch {
        repo.insertWisata(wisataModel)
    }

    fun deleteWisata(wisataModel: WisataModel) = viewModelScope.launch {
        repo.deleteWisata(wisataModel)
    }

    fun listWisata():List<WisataModel> = listOf(
        WisataModel(
            name = "Taman Bunga Impian Okura",
            type = "Pertanian",
            address = "Jl. Sri Sejahtera",
            openHour = "Senin - Minggu/ 10:00 - 18:00 WIB",
            phone = "0813-7144 2725",
            about = "Taman Bunga Impian Okura adalah salah satu destinasi wisata baru yang ada di Kota Pekanbaru, tepatnya di Jalan Kenanga, Kecamatan Tenayan Raya, Pekanbaru. Disini terdapat 7 jenis kelinci, mulai dari kelinci anggora, kelinci lop, kelinci dutch, kelinci lion, dll. \n" +
                    "\n" +
                    "Selain dapat melihat dan bermain dengan kelinci, disini wisatawan dapat memberi makan kelinci. Lalu wisatawan juga dapat bertanya kepada pemilik wisata tentang bagaimana cara merawat kelinci yang baik dan benar.\n" +
                    "\n" +
                    "Jika ingin beristirahat, wisatawan dapat duduk di gazebo yang telah disediakan.",
            lat = 0.5772346611059678,
            long = 101.53225081671332,
            image = R.drawable.wista_a
        ),

        WisataModel(
            name = "Kampoeng Rabbits",
            type = "Pendidikan",
            address = "Jl. Kenanga, Kulim",
            openHour = "Senin - Minggu/ 10:00 - 18:00 WIB",
            phone = "0813-7144 2725",
            about = "Kampoeng Rabbits adalah salah satu destinasi wisata baru yang ada di Kota Pekanbaru, tepatnya di Jalan Kenanga, Kecamatan Tenayan Raya, Pekanbaru. Disini terdapat 7 jenis kelinci, mulai dari kelinci anggora, kelinci lop, kelinci dutch, kelinci lion, dll. \n" +
                    "\n" +
                    "Selain dapat melihat dan bermain dengan kelinci, disini wisatawan dapat memberi makan kelinci. Lalu wisatawan juga dapat bertanya kepada pemilik wisata tentang bagaimana cara merawat kelinci yang baik dan benar.\n" +
                    "\n" +
                    "Jika ingin beristirahat, wisatawan dapat duduk di gazebo yang telah disediakan.",
            lat = 0.48171186092637563,
            long = 101.51613510891951,
            image = R.drawable.wisata_b
        ),

        WisataModel(
            name = "Agrowisata Pelangi",
            type = "Pendidikan",
            address = "Jl. Pasiran Lintas Timur",
            openHour = "Senin - Minggu/ 10:00 - 18:00 WIB",
            phone = "0813-7144 2725",
            about = "Agrowisata Pelangi adalah salah satu destinasi wisata baru yang ada di Kota Pekanbaru, tepatnya di Jalan Kenanga, Kecamatan Tenayan Raya, Pekanbaru. Disini terdapat 7 jenis kelinci, mulai dari kelinci anggora, kelinci lop, kelinci dutch, kelinci lion, dll. \n" +
                    "\n" +
                    "Selain dapat melihat dan bermain dengan kelinci, disini wisatawan dapat memberi makan kelinci. Lalu wisatawan juga dapat bertanya kepada pemilik wisata tentang bagaimana cara merawat kelinci yang baik dan benar.\n" +
                    "\n" +
                    "Jika ingin beristirahat, wisatawan dapat duduk di gazebo yang telah disediakan.",
            lat = 0.47794153524712174,
            long = 101.52156502478262,
            image = R.drawable.wisata_c
        ),

        WisataModel(
            name = "Taman Rekreasi Alam Mayang",
            type = "Buatan",
            address = "Jl. H. Imam Munandar",
            openHour = "Senin - Minggu/ 10:00 - 18:00 WIB",
            phone = "0813-7144 2725",
            about = "Taman Rekreasi Alam Mayang adalah salah satu destinasi wisata baru yang ada di Kota Pekanbaru, tepatnya di Jalan Kenanga, Kecamatan Tenayan Raya, Pekanbaru. Disini terdapat 7 jenis kelinci, mulai dari kelinci anggora, kelinci lop, kelinci dutch, kelinci lion, dll. \n" +
                    "\n" +
                    "Selain dapat melihat dan bermain dengan kelinci, disini wisatawan dapat memberi makan kelinci. Lalu wisatawan juga dapat bertanya kepada pemilik wisata tentang bagaimana cara merawat kelinci yang baik dan benar.\n" +
                    "\n" +
                    "Jika ingin beristirahat, wisatawan dapat duduk di gazebo yang telah disediakan.",
            lat = 0.49206223592483744,
            long = 101.50053023802182,
            image = R.drawable.wisata_d
        ),

        WisataModel(
            name = "Masjid Raya An Nur",
            type = "Religi",
            address = "Jl. Hang Tuah",
            openHour = "Senin - Minggu/ 10:00 - 18:00 WIB",
            phone = "0813-7144 2725",
            about = "Masjid Raya An Nur adalah salah satu destinasi wisata baru yang ada di Kota Pekanbaru, tepatnya di Jalan Kenanga, Kecamatan Tenayan Raya, Pekanbaru. Disini terdapat 7 jenis kelinci, mulai dari kelinci anggora, kelinci lop, kelinci dutch, kelinci lion, dll. \n" +
                    "\n" +
                    "Selain dapat melihat dan bermain dengan kelinci, disini wisatawan dapat memberi makan kelinci. Lalu wisatawan juga dapat bertanya kepada pemilik wisata tentang bagaimana cara merawat kelinci yang baik dan benar.\n" +
                    "\n" +
                    "Jika ingin beristirahat, wisatawan dapat duduk di gazebo yang telah disediakan.",
            lat = 0.49206223592483744,
            long = 101.50053023802182,
            image = R.drawable.wisata_e
        ),
    )

    fun insertDummyData(list:List<WisataModel>) {
        list.forEach {
            insertWisata(it)
        }
    }

    init {
        if (_uiState.value.isEmpty()) {
            insertDummyData(listWisata())
        }
    }



}