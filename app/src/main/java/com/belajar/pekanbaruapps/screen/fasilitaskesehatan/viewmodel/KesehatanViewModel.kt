package com.belajar.pekanbaruapps.screen.fasilitaskesehatan.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.model.KesehatanModel
import com.belajar.pekanbaruapps.repositories.KesehatanRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KesehatanViewModel @Inject constructor(private val repository: KesehatanRepository) :
    ViewModel() {
    private val _uiState = MutableStateFlow<List<KesehatanModel>>(emptyList())
    val uiState = _uiState.asStateFlow()

    fun getKesehatan(search: String) {
        viewModelScope.launch {
            if (search.isEmpty()) {
                repository.getAllKesehatan().collect {
                    _uiState.value = it
                }
            } else {
                repository.searchKesehatan(search).collect {
                    _uiState.value = it
                }
            }
        }
    }

    fun insertKesehatan(hotelModel: KesehatanModel) {
        viewModelScope.launch {
            repository.insertKesehatan(hotelModel)
        }
    }

    fun deleteKesehatan(hotelModel: KesehatanModel) {
        viewModelScope.launch {
            repository.deleteKesehatan(hotelModel)
        }
    }

    val dummyData = listOf(
        KesehatanModel(
            name = "RS Jiwa Tampan",
            akreditas = "A",
            "Jl. HR. Soebrantras JM 12,5, Pekanbaru",
            R.drawable.rs_a,
            phone = "(0761) 21618",
            0.4650942984156822,
            101.38263351271672,
            "RS Jiwa Tampan Provinsi Riau merupakan Rumah Sakit Kelas B Pendidikan, yang mempunyai tugas dan fungsi mencakup upaya pelayanan kesehatan perorangan, pusat rujukan dan pembina Rumah Sakit Kabupaten/Kota se Provinsi Riau serta merupakan tempat pendidikan mahasiswa Fakultas Kedokteran Universitas Riau dan Institusi Pendidikan Kesehatan lainnya.\n" +
                    "\n" +
                    "Percepatan dan perbaikan kinerja pelayanan diupayakan RS Jiwa Tampan Provinsi Riau secara terus menerus ditingkatkan, melalui tiga pendekatan yang sinergis, yaitu pengembangan sarana dan prasarana, pengembangan sumber daya manusiadan perbaikan sistem manajemen kearah profesional secara berkesinambungan melalui sertifikasi akreditasi rumah sakit versi 2012.\n" +
                    "\n" +
                    "Sesuai dengan Peraturan Daerah Provinsi Riau No. 4 Tahun 2016 tentang Pembentukan dan Susunan Perangkat Daerah Provinsi Riau (Lembaran Daerah Provinsi Riau Tahun 2016 Nomor : 4), dalam hal kelembagaan RS Jiwa Tampan Provinsi Riau mengacu kepada Peraturan Gubernur Riau No. 50 Tahun 2015 tentang Rincian Tugas, Fungsi dan Tata Kerja RS Jiwa Tampan Provinsi Riau, dan dinyatakan bahwa kedudukan RS Jiwa Tampan Provinsi Riau adalah perangkat daerahyang diserahi wewenang, tugas dan tanggung jawab untuk melaksanakan upaya kesehatan secara berdayaguna dan berhasilguna, dengan mengutamakan upaya penyembuhan dan pemulihan yang dilaksanakan secara serasi terpadu dengan upaya peningkatan serta pencegahan dan melaksanakan upaya rujukan sesuai dengan peraturan perundang-undangan yang berlaku, yang berada dibawah dan bertanggung jawab kepada Gubernur."
        ),
        KesehatanModel(
            name = "RSUD Arifin Achmad",
            akreditas = "B",
            "Jl. Diponegoro No.2 Pekanbaru",
            R.drawable.rs_b,
            phone = "(0761) 21618",
            0.5233953983360856,
            101.4518904550435,
            "RSUD Arifin Achmad Provinsi Riau merupakan Rumah Sakit Kelas B Pendidikan, yang mempunyai tugas dan fungsi mencakup upaya pelayanan kesehatan perorangan, pusat rujukan dan pembina Rumah Sakit Kabupaten/Kota se Provinsi Riau serta merupakan tempat pendidikan mahasiswa Fakultas Kedokteran Universitas Riau dan Institusi Pendidikan Kesehatan lainnya.\n" +
                    "\n" +
                    "Percepatan dan perbaikan kinerja pelayanan diupayakan RSUD Arifin Achmad Provinsi Riau secara terus menerus ditingkatkan, melalui tiga pendekatan yang sinergis, yaitu pengembangan sarana dan prasarana, pengembangan sumber daya manusiadan perbaikan sistem manajemen kearah profesional secara berkesinambungan melalui sertifikasi akreditasi rumah sakit versi 2012.\n" +
                    "\n" +
                    "Sesuai dengan Peraturan Daerah Provinsi Riau No. 4 Tahun 2016 tentang Pembentukan dan Susunan Perangkat Daerah Provinsi Riau (Lembaran Daerah Provinsi Riau Tahun 2016 Nomor : 4), dalam hal kelembagaan RSUD Arifin Achmad Provinsi Riau mengacu kepada Peraturan Gubernur Riau No. 50 Tahun 2015 tentang Rincian Tugas, Fungsi dan Tata Kerja RSUD Arifin Achmad Provinsi Riau, dan dinyatakan bahwa kedudukan RSUD Arifin Achmad Provinsi Riau adalah perangkat daerahyang diserahi wewenang, tugas dan tanggung jawab untuk melaksanakan upaya kesehatan secara berdayaguna dan berhasilguna, dengan mengutamakan upaya penyembuhan dan pemulihan yang dilaksanakan secara serasi terpadu dengan upaya peningkatan serta pencegahan dan melaksanakan upaya rujukan sesuai dengan peraturan perundang-undangan yang berlaku, yang berada dibawah dan bertanggung jawab kepada Gubernur."
        ),
        KesehatanModel(
            name = "RS Awalbros Pekanbaru",
            akreditas = "B",
            "Jl. Jendral Sudirman No. 117",
            R.drawable.rs_c,
            phone = "(0761) 21618",
            0.5208231309320783,
            101.44838430626486,
            "RS Awalbros Pekanbaru Provinsi Riau merupakan Rumah Sakit Kelas B Pendidikan, yang mempunyai tugas dan fungsi mencakup upaya pelayanan kesehatan perorangan, pusat rujukan dan pembina Rumah Sakit Kabupaten/Kota se Provinsi Riau serta merupakan tempat pendidikan mahasiswa Fakultas Kedokteran Universitas Riau dan Institusi Pendidikan Kesehatan lainnya.\n" +
                    "\n" +
                    "Percepatan dan perbaikan kinerja pelayanan diupayakan RS Awalbros Pekanbaru Provinsi Riau secara terus menerus ditingkatkan, melalui tiga pendekatan yang sinergis, yaitu pengembangan sarana dan prasarana, pengembangan sumber daya manusiadan perbaikan sistem manajemen kearah profesional secara berkesinambungan melalui sertifikasi akreditasi rumah sakit versi 2012.\n" +
                    "\n" +
                    "Sesuai dengan Peraturan Daerah Provinsi Riau No. 4 Tahun 2016 tentang Pembentukan dan Susunan Perangkat Daerah Provinsi Riau (Lembaran Daerah Provinsi Riau Tahun 2016 Nomor : 4), dalam hal kelembagaan RS Awalbros Pekanbaru Provinsi Riau mengacu kepada Peraturan Gubernur Riau No. 50 Tahun 2015 tentang Rincian Tugas, Fungsi dan Tata Kerja RS Awalbros Pekanbaru Provinsi Riau, dan dinyatakan bahwa kedudukan RS Awalbros Pekanbaru Provinsi Riau adalah perangkat daerahyang diserahi wewenang, tugas dan tanggung jawab untuk melaksanakan upaya kesehatan secara berdayaguna dan berhasilguna, dengan mengutamakan upaya penyembuhan dan pemulihan yang dilaksanakan secara serasi terpadu dengan upaya peningkatan serta pencegahan dan melaksanakan upaya rujukan sesuai dengan peraturan perundang-undangan yang berlaku, yang berada dibawah dan bertanggung jawab kepada Gubernur."
        ),
        KesehatanModel(
            name = "RS Madani",
            akreditas = "B",
            "Jl. Garuda Sakti, Pekanbaru",
            R.drawable.rs_d,
            phone = "(0761) 21618",
            0.4823172692573851,
            101.36396903430636,
            "RS Madani Provinsi Riau merupakan Rumah Sakit Kelas B Pendidikan, yang mempunyai tugas dan fungsi mencakup upaya pelayanan kesehatan perorangan, pusat rujukan dan pembina Rumah Sakit Kabupaten/Kota se Provinsi Riau serta merupakan tempat pendidikan mahasiswa Fakultas Kedokteran Universitas Riau dan Institusi Pendidikan Kesehatan lainnya.\n" +
                    "\n" +
                    "Percepatan dan perbaikan kinerja pelayanan diupayakan RS Madani Provinsi Riau secara terus menerus ditingkatkan, melalui tiga pendekatan yang sinergis, yaitu pengembangan sarana dan prasarana, pengembangan sumber daya manusiadan perbaikan sistem manajemen kearah profesional secara berkesinambungan melalui sertifikasi akreditasi rumah sakit versi 2012.\n" +
                    "\n" +
                    "Sesuai dengan Peraturan Daerah Provinsi Riau No. 4 Tahun 2016 tentang Pembentukan dan Susunan Perangkat Daerah Provinsi Riau (Lembaran Daerah Provinsi Riau Tahun 2016 Nomor : 4), dalam hal kelembagaan RS Madani Provinsi Riau mengacu kepada Peraturan Gubernur Riau No. 50 Tahun 2015 tentang Rincian Tugas, Fungsi dan Tata Kerja RS Madani Provinsi Riau, dan dinyatakan bahwa kedudukan RS Madani Provinsi Riau adalah perangkat daerahyang diserahi wewenang, tugas dan tanggung jawab untuk melaksanakan upaya kesehatan secara berdayaguna dan berhasilguna, dengan mengutamakan upaya penyembuhan dan pemulihan yang dilaksanakan secara serasi terpadu dengan upaya peningkatan serta pencegahan dan melaksanakan upaya rujukan sesuai dengan peraturan perundang-undangan yang berlaku, yang berada dibawah dan bertanggung jawab kepada Gubernur."
        ),
        KesehatanModel(
            name = "RS Santa Maria",
            akreditas = "B",
            "Jl. Jendral A. Yani, No, 68",
            R.drawable.rs_e,
            phone = "(0761) 21618",
            0.5275508253333675,
            101.44216885318716,
            "RS Santa Maria Provinsi Riau merupakan Rumah Sakit Kelas B Pendidikan, yang mempunyai tugas dan fungsi mencakup upaya pelayanan kesehatan perorangan, pusat rujukan dan pembina Rumah Sakit Kabupaten/Kota se Provinsi Riau serta merupakan tempat pendidikan mahasiswa Fakultas Kedokteran Universitas Riau dan Institusi Pendidikan Kesehatan lainnya.\n" +
                    "\n" +
                    "Percepatan dan perbaikan kinerja pelayanan diupayakan RS Santa Maria Provinsi Riau secara terus menerus ditingkatkan, melalui tiga pendekatan yang sinergis, yaitu pengembangan sarana dan prasarana, pengembangan sumber daya manusiadan perbaikan sistem manajemen kearah profesional secara berkesinambungan melalui sertifikasi akreditasi rumah sakit versi 2012.\n" +
                    "\n" +
                    "Sesuai dengan Peraturan Daerah Provinsi Riau No. 4 Tahun 2016 tentang Pembentukan dan Susunan Perangkat Daerah Provinsi Riau (Lembaran Daerah Provinsi Riau Tahun 2016 Nomor : 4), dalam hal kelembagaan RS Santa Maria Provinsi Riau mengacu kepada Peraturan Gubernur Riau No. 50 Tahun 2015 tentang Rincian Tugas, Fungsi dan Tata Kerja RS Santa Maria Provinsi Riau, dan dinyatakan bahwa kedudukan RS Santa Maria Provinsi Riau adalah perangkat daerahyang diserahi wewenang, tugas dan tanggung jawab untuk melaksanakan upaya kesehatan secara berdayaguna dan berhasilguna, dengan mengutamakan upaya penyembuhan dan pemulihan yang dilaksanakan secara serasi terpadu dengan upaya peningkatan serta pencegahan dan melaksanakan upaya rujukan sesuai dengan peraturan perundang-undangan yang berlaku, yang berada dibawah dan bertanggung jawab kepada Gubernur."
        )
    )

    fun insertData(list:List<KesehatanModel>) =
        list.forEach {
            insertKesehatan(it)
        }

    init {

        if (_uiState.value.isEmpty()) {
            insertData(dummyData)
        }
    }
}
