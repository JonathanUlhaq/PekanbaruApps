package com.belajar.pekanbaruapps.screen.hotel.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.pekanbaruapps.R
import com.belajar.pekanbaruapps.model.HotelModel
import com.belajar.pekanbaruapps.repositories.HotelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotelViewModel @Inject constructor(private val repository: HotelRepository):ViewModel() {
    private val _uiState = MutableStateFlow<List<HotelModel>>(emptyList())
    val uiState = _uiState.asStateFlow()

    fun getHotel(search:String) {
        viewModelScope.launch {
            if (search.isEmpty()) {
               repository.getAllHotel().collect{
                   _uiState.value = it
               }
            } else {
                repository.searchHotel(search).collect {
                    _uiState.value = it
                }
            }
        }
    }

    fun insertHotel(hotelModel: HotelModel) {
        viewModelScope.launch {
            repository.insertHotel(hotelModel)
        }
    }

    fun deleteHotel(hotelModel: HotelModel) {
        viewModelScope.launch {
            repository.deleteHotel(hotelModel)
        }
    }

    fun insertDummyData() {
        val listHotel = listOf<HotelModel>(
            HotelModel(hotelName = "Fave Hotel",
                    hotelAddress = "Jl. Pinang No.10, Wonorejo, Kota Pekanbaru",
                    hotelRating = "4",
                    aboutHotel = "Terletak di area komersial, hotel modern murah ini berjarak 3 km dari pusat perbelanjaan di Sudirman City Square, 4 km dari Masjid Agung An-Nur, dan 5 km dari Bandara Internasional Sultan Syarif Kasim II.\n" +
                            "Kamar-kamar santai dengan jendela setinggi langit-langit, akses Wi-Fi, TV layar datar, dan brankas. Tersedia kamar yang saling terhubung.\n" +
                            "Fasilitas terdiri dari sarapan (dengan biaya tambahan) yang disajikan di restoran bernuansa cerah, serta ruang rapat.",
                    lat = 0.5038748921182046,
                    long = 101.45237359192193,
                    image = R.drawable.foto_a),

            HotelModel(hotelName = "Ayola Hotel",
                hotelAddress = "Jl. Pinang No.10, Kota Pekanbaru",
                hotelRating = "3",
                aboutHotel = "Hotel kasual yang terletak di pinggir jalan utama ini berjarak 10 km dari Bandara Internasional Sultan Syarif Kasim II dan 16 km dari Boombara Waterpark.\n" +
                        "Kamar simpel dilengkapi dengan Wi-Fi gratis, TV layar datar, kulkas mini, serta fasilitas pembuat teh dan kopi. Kamar keluarga memiliki kamar tidur dengan pintu penghubung. Suite memiliki ruang keluarga terpisah. Tersedia room service 24 jam.\n" +
                        "Tersedia gratis antar-jemput ke bandara. Fasilitas lainnya berupa gym, dan kolam renang outdoor dengan kolam renang anak. Sarapan ditawarkan (berbayar).",
                lat = 0.46467264555739723,
                long = 101.40977947655882,
                image = R.drawable.foto_b ),

            HotelModel(hotelName = "Zuri Hotel",
                hotelAddress = "Jl. Teuku Umar No.7, Kota Pekanbaru",
                hotelRating = "5",
                aboutHotel = "Hotel mewah di pusat kota ini berjarak satu menit berjalan kaki dari Mal Senapelan Pekanbaru, 5 km dari pameran budaya di Museum Sang Nila Utama, 9 km dari Bandara Internasional Sultan Syarif Kasim II.\n" +
                        "Kamar-kamar mewah meliputi TV satelit, Wi-Fi gratis, pembuat kopi dan teh, serta minibar dan brankas. Suite memiliki tambahan area ruang keluarga terpisah dan meja kerja. Tersedia room service.\n" +
                        "Fasilitas meliputi antar-jemput bandara gratis, restoran kasual dan musala, ditambah kolam renang outdoor, dan area spa dengan gym dan sauna. Ada juga business center dan apotek.",
                lat = 0.532300613250957,
                long = 101.44898998723829,
                image = R.drawable.foto_c ),

            HotelModel(hotelName = "Arya Duta Hotel",
                hotelAddress = "Jl. Diponegoro No.34, Kota Pekanbaru",
                hotelRating = "4",
                aboutHotel = "Hotel megah yang terletak di antara taman jalanan utama di kawasan pemerintahan ini berjarak 2 km dari Masjid Agung An-Nur Pekanbaru dan 7 km dari Bandara Internasional Sultan Syarif Kasim II.\n" +
                        "Kamar-kamar mewah dan modern menawarkan Wi-Fi gratis dan TV kabel, ditambah minibar, area duduk, serta pembuat kopi dan teh. Suite memiliki tambahan ruang keluarga terpisah, serta layanan gratis seperti keranjang buah dan antar-jemput bandara. Suite di kelas yang lebih tinggi memiliki ruang makan. Tersedia room service 24 jam.\n" +
                        "Fasilitas meliputi bistro, restoran kasual 24 jam, dan lounge lobi, serta toko kue. Ada juga gym dan kolam renang outdoor bergaya laguna yang diapit oleh pohon-pohon palem.",
                lat = 0.5153342166434604,
                long = 101.4519570578791,
                image = R.drawable.foto_d ),

            HotelModel(hotelName = "The Premiere Hotel",
                hotelAddress = "Jl. Jend. Sudirman No.389,Kota Pekanbaru",
                hotelRating = "3",
                aboutHotel = "Terletak di sebuah menara tinggi di pusat kota Pekanbaru, hotel mewah ini berjarak 5 km dari Museum Sang Nila Utama dan 3 km dari Perpustakaan Soeman HS Provinsi Riau.\n" +
                        "Kamar yang luas dengan Wi-Fi, TV layar datar, minibar, dan brankas, serta alat pembuat teh dan kopi. Suite mewah memiliki ruang keluarga terpisah. Room service tersedia 24 jam.\n" +
                        "Terdapat restoran internasional 24 jam, bar karaoke, dan lounge dengan gudang wine dan ruang cerutu. Fasilitas juga meliputi spa, pusat kebugaran, kedai jus, kolam renang outdoor, dan kolam rendam air panas. Tersedia tempat parkir dan sarapan.",
                lat = 0.5127907157397692,
                long = 101.44869774905904,
                image = R.drawable.foto_e ),

            HotelModel(hotelName = "Batiqa Hotel",
                hotelAddress = "Jl. Jend. Sudirman No.17, Kota Pekanbaru",
                hotelRating = "4",
                aboutHotel = "Hotel santai yang terletak di kawasan komersial ini berjarak 8 km dari Labersa Water Park dan Masjid Agung An-Nur, serta 1 km dari Bandara Internasional Sultan Syarif Kasim II.\n" +
                        "Kamar dan suite dilengkapi dengan furnitur simpel dan menyediakan Wi-Fi gratis, TV layar datar, kulkas mini, brankas di dalam kamar, serta fasilitas pembuat teh dan kopi.\n" +
                        "Antar-jemput bandara tersedia gratis. Fasilitas lainnya meliputi restoran, gym, dan spa. Ruang pertemuan tersedia.",
                lat = 0.4714808356088837,
                long = 101.45484765359205,
                image = R.drawable.foto_f ),

        )

        listHotel.forEach {
            insertHotel(it)
        }
    }

    init {
        if (_uiState.value.isEmpty()) {
            insertDummyData()
        }

    }

}