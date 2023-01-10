package com.belajar.pekanbaruapps.screen.berita.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.model.BeritaModel
import com.belajar.pekanbaruapps.model.SMPModel
import com.belajar.pekanbaruapps.repositories.BeritaRepository
import com.belajar.pekanbaruapps.repositories.SMPRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeritaViewModel @Inject constructor(private val repo: BeritaRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<List<BeritaModel>>(emptyList())
    val uiState = _uiState.asStateFlow()

    fun getAllBerita(search: String) = viewModelScope.launch {
        if (search.isEmpty()) {
            repo.getAllBerita().collect {
                _uiState.value = it
            }
        } else {
            repo.searchBerita(search).collect {
                _uiState.value = it
            }
        }
    }

    fun insertBerita(smpModel: BeritaModel) = viewModelScope.launch {
        repo.insertBerita(smpModel)
    }

    fun deleteBerita(smpModel: BeritaModel) = viewModelScope.launch {
        repo.deleteBerita(smpModel)
    }

    val dummyData = listOf(
        BeritaModel(
            "Pemko Pekanbaru Masih Berjuang Hadapi Pandemi Covid-19",
            listOf(
                "Informasi",
                "Covid"
            ),
            "Januari 2, 2023",
            "200",
            "PEKANBARU - Pemerintah Kota (Pemko) masih berjuang menghadapi pandemi Covid-19. Berbagai upaya telah dilakukan guna memutus mata rantai Covid-19 melalui kebijakan pemberlakuan pembatasan kegiatan masyarakat (PPKM).\n" +
                    "\n" +
                    "\"Kami juga secara masif memberikan layanan vaksinasi kepada seluruh masyarakat hingga dapat tercapainya kekebalan kelompok (herd immunity),\" kata Penjabat (Pj) Walikota Pekanbaru Muflihun, Ahad (1/1).\n" +
                    "\n" +
                    "Sejak diberi amanah sebagai Pj Walikota pada 23 Mei lalu, banyak tugas yang diberikan oleh pemerintah pusat dan Pemerintah Provinsi Riau. Tugas dari pemerintah pusat itu adalah menekan angka Covid-19 dan menuntaskan vaksinasi.\n" +
                    "\n" +
                    "''Sejak Februari 2021 hingga 27 Desember 2022, capaian vaksin dosis pertama sudah mencapai 105,27 persen atau 895.928 orang,\" sebut Muflihun.\n" +
                    "\n" +
                    "Vaksinasi dosis kedua 88,91 persen atau 756.703 orang. Vaksinasi dosis ketiga 38,12 persen atau 231.638 orang.\n" +
                    "\n" +
                    "\"Capaian vaksinasi booster ini masih rendah. Kami juga telah memulai vaksinasi dosis keempat dengan jumlah 4.339 orang atau 2,01 persen,\" ujar Muflihun. (Kominfo11/RD5)",
            R.drawable.berita_a
        ),

        BeritaModel(
            "Pemko Pekanbaru Paparkan Pencapaian Progam dan Kegiatan Selama 2022",
            listOf(
                "Informasi"
            ),
            "Januari 2, 2023",
            "180",
            "PEKANBARU - Pemerintah Kota (Pemko) masih berjuang menghadapi pandemi Covid-19. Berbagai upaya telah dilakukan guna memutus mata rantai Covid-19 melalui kebijakan pemberlakuan pembatasan kegiatan masyarakat (PPKM).\n" +
                    "\n" +
                    "\"Kami juga secara masif memberikan layanan vaksinasi kepada seluruh masyarakat hingga dapat tercapainya kekebalan kelompok (herd immunity),\" kata Penjabat (Pj) Walikota Pekanbaru Muflihun, Ahad (1/1).\n" +
                    "\n" +
                    "Sejak diberi amanah sebagai Pj Walikota pada 23 Mei lalu, banyak tugas yang diberikan oleh pemerintah pusat dan Pemerintah Provinsi Riau. Tugas dari pemerintah pusat itu adalah menekan angka Covid-19 dan menuntaskan vaksinasi.\n" +
                    "\n" +
                    "''Sejak Februari 2021 hingga 27 Desember 2022, capaian vaksin dosis pertama sudah mencapai 105,27 persen atau 895.928 orang,\" sebut Muflihun.\n" +
                    "\n" +
                    "Vaksinasi dosis kedua 88,91 persen atau 756.703 orang. Vaksinasi dosis ketiga 38,12 persen atau 231.638 orang.\n" +
                    "\n" +
                    "\"Capaian vaksinasi booster ini masih rendah. Kami juga telah memulai vaksinasi dosis keempat dengan jumlah 4.339 orang atau 2,01 persen,\" ujar Muflihun. (Kominfo11/RD5)",
            R.drawable.berita_b
        ),

        BeritaModel(
            "Realisasi PAD Pajak Bapenda 2022 Capai 97 Persen",
            listOf(
                "Informasi"
            ),
            "Januari 1, 2023",
            "540",
            "PEKANBARU - Pemerintah Kota (Pemko) masih berjuang menghadapi pandemi Covid-19. Berbagai upaya telah dilakukan guna memutus mata rantai Covid-19 melalui kebijakan pemberlakuan pembatasan kegiatan masyarakat (PPKM).\n" +
                    "\n" +
                    "\"Kami juga secara masif memberikan layanan vaksinasi kepada seluruh masyarakat hingga dapat tercapainya kekebalan kelompok (herd immunity),\" kata Penjabat (Pj) Walikota Pekanbaru Muflihun, Ahad (1/1).\n" +
                    "\n" +
                    "Sejak diberi amanah sebagai Pj Walikota pada 23 Mei lalu, banyak tugas yang diberikan oleh pemerintah pusat dan Pemerintah Provinsi Riau. Tugas dari pemerintah pusat itu adalah menekan angka Covid-19 dan menuntaskan vaksinasi.\n" +
                    "\n" +
                    "''Sejak Februari 2021 hingga 27 Desember 2022, capaian vaksin dosis pertama sudah mencapai 105,27 persen atau 895.928 orang,\" sebut Muflihun.\n" +
                    "\n" +
                    "Vaksinasi dosis kedua 88,91 persen atau 756.703 orang. Vaksinasi dosis ketiga 38,12 persen atau 231.638 orang.\n" +
                    "\n" +
                    "\"Capaian vaksinasi booster ini masih rendah. Kami juga telah memulai vaksinasi dosis keempat dengan jumlah 4.339 orang atau 2,01 persen,\" ujar Muflihun. (Kominfo11/RD5)",
            R.drawable.berita_c
        ),

        BeritaModel(
            "Kesiapan Pengelolaan Sampah 2023, Pj Sekdako Tinjau TPA Muara Fajar",
            listOf(
                "Informasi"
            ),
            "Januari 1, 2023",
            "200",
            "PEKANBARU - Pemerintah Kota (Pemko) masih berjuang menghadapi pandemi Covid-19. Berbagai upaya telah dilakukan guna memutus mata rantai Covid-19 melalui kebijakan pemberlakuan pembatasan kegiatan masyarakat (PPKM).\n" +
                    "\n" +
                    "\"Kami juga secara masif memberikan layanan vaksinasi kepada seluruh masyarakat hingga dapat tercapainya kekebalan kelompok (herd immunity),\" kata Penjabat (Pj) Walikota Pekanbaru Muflihun, Ahad (1/1).\n" +
                    "\n" +
                    "Sejak diberi amanah sebagai Pj Walikota pada 23 Mei lalu, banyak tugas yang diberikan oleh pemerintah pusat dan Pemerintah Provinsi Riau. Tugas dari pemerintah pusat itu adalah menekan angka Covid-19 dan menuntaskan vaksinasi.\n" +
                    "\n" +
                    "''Sejak Februari 2021 hingga 27 Desember 2022, capaian vaksin dosis pertama sudah mencapai 105,27 persen atau 895.928 orang,\" sebut Muflihun.\n" +
                    "\n" +
                    "Vaksinasi dosis kedua 88,91 persen atau 756.703 orang. Vaksinasi dosis ketiga 38,12 persen atau 231.638 orang.\n" +
                    "\n" +
                    "\"Capaian vaksinasi booster ini masih rendah. Kami juga telah memulai vaksinasi dosis keempat dengan jumlah 4.339 orang atau 2,01 persen,\" ujar Muflihun. (Kominfo11/RD5)",
            R.drawable.berita_d
        )
    )

    fun insertDummyData(list:List<BeritaModel>) =
        list.forEach {
            insertBerita(it)
        }

    init {

        if (_uiState.value.isEmpty()) {
            insertDummyData(dummyData)
        }
    }
}