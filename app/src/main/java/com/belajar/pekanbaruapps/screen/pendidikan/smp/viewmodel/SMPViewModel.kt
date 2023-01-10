package com.belajar.pekanbaruapps.screen.pendidikan.smp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.model.SDModel
import com.belajar.pekanbaruapps.model.SMPModel
import com.belajar.pekanbaruapps.repositories.SDRepository
import com.belajar.pekanbaruapps.repositories.SMPRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SMPViewModel @Inject constructor(private val repo: SMPRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<List<SMPModel>>(emptyList())
    val uiState = _uiState.asStateFlow()

    fun getAllSMP(search: String) = viewModelScope.launch {
        if (search.isEmpty()) {
            repo.getAllSMP().collect {
                _uiState.value = it
            }
        } else {
            repo.searchSMP(search).collect {
                _uiState.value = it
            }
        }
    }

    fun insertSMP(smpModel: SMPModel) = viewModelScope.launch {
        repo.insertSMP(smpModel)
    }

    fun deleteSMP(smpModel: SMPModel) = viewModelScope.launch {
        repo.deleteSMP(smpModel)
    }

    val dummyData:List<SMPModel> = listOf(
        SMPModel(name = "SMP Negeri 10 Pekanbaru",
            type = "Negeri",
            akreditasi = "A",
            address = "Jl. Dr. Sutomo 108",
            image = R.drawable.smp_a,
            phone = "0821-2257-9634",
            lat = 0.5270496785608105,
            long =  101.45622833395466,
            about = "SMP Negeri 10 Pekanbaru adalah salah satu satuan pendidikan dengan jenjang SD di PADANG BULAN, Kec. Senapelan, Kota Pekanbaru, Riau. Dalam menjalankan kegiatannya, SMP Negeri 10 Pekanbaru berada di bawah naungan Kementerian Pendidikan dan Kebudayaan.\n" +
                    "\n" +
                    "SMP Negeri 10 Pekanbaru menyediakan listrik untuk membantu kegiatan belajar mengajar. Sumber listrik yang digunakan oleh SMP Negeri 10 Pekanbaru berasal dari PLN. Pembelajaran di SMP Negeri 10 Pekanbaru dilakukan pada Pagi. Dalam seminggu, pembelajaran dilakukan selama 6 hari."
        ),

        SMPModel(name = "SMP UNGGULAN TERPADU IBNU AL MUBAROK",
            type = "Swasta",
            akreditasi = "A",
            address = "Jl. Jend. Sudirman No.1, Sukaramai",
            image = R.drawable.smp_b,
            phone = "0821-2257-9634",
            lat = 0.6074646683435279,
            long =  101.39689879426693,
            about = "SMP UNGGULAN TERPADU IBNU AL MUBAROK adalah salah satu satuan pendidikan dengan jenjang SD di PADANG BULAN, Kec. Senapelan, Kota Pekanbaru, Riau. Dalam menjalankan kegiatannya, SMP UNGGULAN TERPADU IBNU AL MUBAROK berada di bawah naungan Kementerian Pendidikan dan Kebudayaan.\n" +
                    "\n" +
                    "SMP UNGGULAN TERPADU IBNU AL MUBAROK menyediakan listrik untuk membantu kegiatan belajar mengajar. Sumber listrik yang digunakan oleh SMP UNGGULAN TERPADU IBNU AL MUBAROK berasal dari PLN. Pembelajaran di SMP UNGGULAN TERPADU IBNU AL MUBAROK dilakukan pada Pagi. Dalam seminggu, pembelajaran dilakukan selama 6 hari."
        ),

        SMPModel(name = "SMP Negeri 43 Pekanbaru",
            type = "Negeri",
            akreditasi = "B",
            address = "Jl. Pemudi Gg. Kukuh",
            image = R.drawable.smp_c,
            phone = "0821-2257-9634",
            lat = 0.5425977980879668,
            long =  101.41002481086043,
            about = "SMP Negeri 43 Pekanbaru adalah salah satu satuan pendidikan dengan jenjang SD di PADANG BULAN, Kec. Senapelan, Kota Pekanbaru, Riau. Dalam menjalankan kegiatannya, SMP Negeri 43 Pekanbaru berada di bawah naungan Kementerian Pendidikan dan Kebudayaan.\n" +
                    "\n" +
                    "SMP Negeri 43 Pekanbaru menyediakan listrik untuk membantu kegiatan belajar mengajar. Sumber listrik yang digunakan oleh SMP Negeri 43 Pekanbaru berasal dari PLN. Pembelajaran di SMP Negeri 43 Pekanbaru dilakukan pada Pagi. Dalam seminggu, pembelajaran dilakukan selama 6 hari."
        ),

        SMPModel(name = "SMP Negeri 5 Pekanbaru",
            type = "Negeri",
            akreditasi = "A",
            address = "Jl. Air Hitam",
            image = R.drawable.smp_d,
            phone = "0821-2257-9634",
            lat = 0.5269712544748952,
            long =  101.45424881807979,
            about = "SMP Negeri 5 Pekanbaru adalah salah satu satuan pendidikan dengan jenjang SD di PADANG BULAN, Kec. Senapelan, Kota Pekanbaru, Riau. Dalam menjalankan kegiatannya, SMP Negeri 5 Pekanbaru berada di bawah naungan Kementerian Pendidikan dan Kebudayaan.\n" +
                    "\n" +
                    "SMP Negeri 5 Pekanbaru menyediakan listrik untuk membantu kegiatan belajar mengajar. Sumber listrik yang digunakan oleh SMP Negeri 5 Pekanbaru berasal dari PLN. Pembelajaran di SMP Negeri 5 Pekanbaru dilakukan pada Pagi. Dalam seminggu, pembelajaran dilakukan selama 6 hari."
        )
    )

    fun insertDummyData(list:List<SMPModel>) =
        list.forEach {
            insertSMP(it)
        }

    init {

        if (_uiState.value.isEmpty()) {
            insertDummyData(dummyData)
        }
    }

}