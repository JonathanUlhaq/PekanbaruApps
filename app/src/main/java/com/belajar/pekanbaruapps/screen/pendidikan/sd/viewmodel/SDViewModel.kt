package com.belajar.pekanbaruapps.screen.pendidikan.sd.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.model.SDModel
import com.belajar.pekanbaruapps.repositories.SDRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SDViewModel @Inject constructor(private val repo: SDRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<List<SDModel>>(emptyList())
    val uiState = _uiState.asStateFlow()

    fun getAllSD(search:String) = viewModelScope.launch {
        if (search.isEmpty()) {
            repo.getAllSD().collect {
                _uiState.value = it
            }
        } else {
            repo.searchSD(search).collect {
                _uiState.value = it
            }
        }
    }

    fun insertSD(sdModel: SDModel) = viewModelScope.launch {
        repo.insertSD(sdModel)
    }

    fun deleteSD(sdModel: SDModel) = viewModelScope.launch {
        repo.deleteSD(sdModel)
    }

    val dummyData:List<SDModel> = listOf(
        SDModel(name = "SD Negeri 1 Pekanbaru",
                type = "Negeri",
                akreditasi = "A",
        address = "Jl. Ahmad Yani No. 04 Pekanbaru",
            image = R.drawable.sd_a,
            phone = "0821-2257-9634",
            lat = 0.531353287399729,
            long =  101.44249621737073,
            about = "SD Negeri 1 Pekanbaru adalah salah satu satuan pendidikan dengan jenjang SD di PADANG BULAN, Kec. Senapelan, Kota Pekanbaru, Riau. Dalam menjalankan kegiatannya, SD Negeri 1 Pekanbaru berada di bawah naungan Kementerian Pendidikan dan Kebudayaan.\n" +
                    "\n" +
                    "SD Negeri 1 Pekanbaru menyediakan listrik untuk membantu kegiatan belajar mengajar. Sumber listrik yang digunakan oleh SD Negeri 1 Pekanbaru berasal dari PLN. Pembelajaran di SD Negeri 1 Pekanbaru dilakukan pada Pagi. Dalam seminggu, pembelajaran dilakukan selama 6 hari."
        ),
        SDModel(name = "SD Negeri 10 Pekanbaru",
            type = "Negeri",
            akreditasi = "B",
            address = "Jl. Ahmad Yani",
            image = R.drawable.sd_b,
            phone = "0821-2257-9634",
            lat = 0.531321767193146,
            long =  101.44250962869356,
            about = "SD Negeri 10 Pekanbaru adalah salah satu satuan pendidikan dengan jenjang SD di PADANG BULAN, Kec. Senapelan, Kota Pekanbaru, Riau. Dalam menjalankan kegiatannya, SD Negeri 10 Pekanbaru berada di bawah naungan Kementerian Pendidikan dan Kebudayaan.\n" +
                    "\n" +
                    "SD Negeri 10 Pekanbaru menyediakan listrik untuk membantu kegiatan belajar mengajar. Sumber listrik yang digunakan oleh SD Negeri 10 Pekanbaru berasal dari PLN. Pembelajaran di SD Negeri 10 Pekanbaru dilakukan pada Pagi. Dalam seminggu, pembelajaran dilakukan selama 6 hari."
        ),
        SDModel(name = "SD Negeri 100 Pekanbaru",
            type = "Negeri",
            akreditasi = "B",
            address = "Jl. Ahmad Yani",
            image = R.drawable.sd_b,
            phone = "0821-2257-9634",
            lat = 0.531321767193146,
            long =  101.44250962869356,
            about = "SD Negeri 100 Pekanbaru adalah salah satu satuan pendidikan dengan jenjang SD di PADANG BULAN, Kec. Senapelan, Kota Pekanbaru, Riau. Dalam menjalankan kegiatannya, SD Negeri 100 Pekanbaru berada di bawah naungan Kementerian Pendidikan dan Kebudayaan.\n" +
                    "\n" +
                    "SD Negeri 100 Pekanbaru menyediakan listrik untuk membantu kegiatan belajar mengajar. Sumber listrik yang digunakan oleh SD Negeri 100 Pekanbaru berasal dari PLN. Pembelajaran di SD Negeri 100 Pekanbaru dilakukan pada Pagi. Dalam seminggu, pembelajaran dilakukan selama 6 hari."
        ),
        SDModel(name = "SD Negeri 100 Pekanbaru",
            type = "Negeri",
            akreditasi = "A",
            address = "Jl. Lili Nomor.18",
            image = R.drawable.sd_c,
            phone = "0821-2257-9634",
            lat = 0.5274627852623179,
            long =  101.43318346172383,
            about = "SD Negeri 100 Pekanbaru adalah salah satu satuan pendidikan dengan jenjang SD di PADANG BULAN, Kec. Senapelan, Kota Pekanbaru, Riau. Dalam menjalankan kegiatannya, SD Negeri 100 Pekanbaru berada di bawah naungan Kementerian Pendidikan dan Kebudayaan.\n" +
                    "\n" +
                    "SD Negeri 100 Pekanbaru menyediakan listrik untuk membantu kegiatan belajar mengajar. Sumber listrik yang digunakan oleh SD Negeri 100 Pekanbaru berasal dari PLN. Pembelajaran di SD Negeri 100 Pekanbaru dilakukan pada Pagi. Dalam seminggu, pembelajaran dilakukan selama 6 hari."
        ),
        SDModel(name = "SD Al Kautsar",
            type = "Swasta",
            akreditasi = "A",
            address = "Jl. Arifin Ahmad No.09",
            image = R.drawable.sd_d,
            phone = "0821-2257-9634",
            lat = 0.4689439447107959,
            long =  101.39612072662985,
            about = "SD Al Kautsar adalah salah satu satuan pendidikan dengan jenjang SD di PADANG BULAN, Kec. Senapelan, Kota Pekanbaru, Riau. Dalam menjalankan kegiatannya, SD Al Kautsar berada di bawah naungan Kementerian Pendidikan dan Kebudayaan.\n" +
                    "\n" +
                    "SD Al Kautsar menyediakan listrik untuk membantu kegiatan belajar mengajar. Sumber listrik yang digunakan oleh SD Al Kautsar berasal dari PLN. Pembelajaran di SD Al Kautsar dilakukan pada Pagi. Dalam seminggu, pembelajaran dilakukan selama 6 hari."
        )
    )

    fun insertDummyData(list:List<SDModel>) =
        list.forEach {
            insertSD(it)
        }

    init {
        if (_uiState.value.isEmpty()) {
            insertDummyData(dummyData)
        }
    }
}