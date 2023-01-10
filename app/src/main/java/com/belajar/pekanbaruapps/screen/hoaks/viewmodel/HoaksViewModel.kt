package com.belajar.pekanbaruapps.screen.hoaks.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.model.BeritaModel
import com.belajar.pekanbaruapps.model.HoaksModel
import com.belajar.pekanbaruapps.repositories.BeritaRepository
import com.belajar.pekanbaruapps.repositories.HoaksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HoaksViewModel @Inject constructor(private val repo: HoaksRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<List<HoaksModel>>(emptyList())
    val uiState = _uiState.asStateFlow()

    fun getAllHoaks(search: String) = viewModelScope.launch {
        if (search.isEmpty()) {
            repo.getAllHoaks().collect {
                _uiState.value = it
            }
        } else {
            repo.searchHoaks(search).collect {
                _uiState.value = it
            }
        }
    }

    fun insertHoaks(smpModel: HoaksModel) = viewModelScope.launch {
        repo.insertHoaks(smpModel)
    }

    fun deleteHoaks(smpModel: HoaksModel) = viewModelScope.launch {
        repo.deleteHoaks(smpModel)
    }

    val dummyData = listOf(
        HoaksModel(
            "[HOAKS] Mantar wakil presede ke-6 RI Try Sutrisno Meninggal Pada Desember 2022",
            "Desember 22, 2022",
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
            R.drawable.hoaks_a
        ),

        HoaksModel(
            "[HOAKS] Akun Whatsapp mengatasnamakan Sekretaris Daerah Kabupaten Buleleng\n",
            "Desember 22, 2022",
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
            R.drawable.hoaks_b
        ),

        HoaksModel(
            "[HOAKS] Lowongan kerja mengatasnamakan PT Angkasa Pura",
            "Desember 22, 2022",
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
            R.drawable.hoaks_c
        ),

        HoaksModel(
            "[DISIMFORMASI] Vaksin Covid-19 menyebabkan kanker turbo",
            "Desember 22, 2022",
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
            R.drawable.hoaks_d
        )
    )

    fun insertDummyData(list:List<HoaksModel>) =
        list.forEach {
            insertHoaks(it)
        }

    init {

        if (_uiState.value.isEmpty()) {
            insertDummyData(dummyData)
        }
    }
}