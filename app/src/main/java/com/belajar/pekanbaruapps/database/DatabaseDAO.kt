package com.belajar.pekanbaruapps.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.belajar.pekanbaruapps.model.*
import kotlinx.coroutines.flow.Flow

@Dao
interface DatabaseDAO {

//    Hotel DOA

    @Query("SELECT * FROM tb_hotel")
    fun getAllHotel(): Flow<List<HotelModel>>

    @Query("SELECT * FROM tb_hotel WHERE hotel_name LIKE '%' || :search || '%' OR hotel_rating LIKE '%' || :search || '%' ")
    fun searchHotel(search: String): Flow<List<HotelModel>>

    @Query("SELECT * FROM tb_hotel WHERE hotel_name = :name")
    fun hotelByName(name: String): Flow<HotelModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHotel(hotelModel: HotelModel)

    @Delete
    suspend fun deleteHotel(hotelModel: HotelModel)


    //    Restoran DAO
    @Query("SELECT * FROM tb_restaurant")
    fun getAllRestaurant(): Flow<List<RestaurantModel>>

    @Query("SELECT * FROM tb_restaurant WHERE nama LIKE '%' || :search || '%' OR kecamatan LIKE '%' || :search || '%'")
    fun getRestaurantBySearch(search: String): Flow<List<RestaurantModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurant(restaurantModel: RestaurantModel)

    @Delete
    suspend fun deleteRestaurant(restaurantModel: RestaurantModel)

    //    Wisata DAO
    @Query("SELECT * FROM wisata_tb")
    fun getAllWisata(): Flow<List<WisataModel>>

    @Query("SELECT * FROM wisata_tb WHERE name LIKE '%' || :search || '%' OR type LIKE '%' || :search || '%'")
    fun getWisataBySearch(search: String): Flow<List<WisataModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWisata(restaurantModel: WisataModel)

    @Delete
    suspend fun deleteWisata(restaurantModel: WisataModel)


    //    Pembelanjaan
    @Query("SELECT * FROM belanja_tb")
    fun getAllPembelanjaan(): Flow<List<BelanjaModel>>

    @Query("SELECT * FROM belanja_tb WHERE name LIKE '%' || :search || '%' OR address LIKE '%' || :search || '%'")
    fun getPembelanjaanBySearch(search: String): Flow<List<BelanjaModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPembelanjaan(belanjaModel: BelanjaModel)

    @Delete
    suspend fun deletePembelanjaan(belanjaModel: BelanjaModel)

    //    SD
    @Query("SELECT * FROM tb_sd")
    fun getAllSD(): Flow<List<SDModel>>

    @Query("SELECT * FROM tb_sd WHERE name LIKE '%' || :search || '%' OR akreditasi LIKE '%' || :search || '%'OR type LIKE '%' || :search || '%'")
    fun getSDBySearch(search: String): Flow<List<SDModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSD(sdModel: SDModel)

    @Delete
    suspend fun deleteSD(sdModel: SDModel)

    //    SMP
    @Query("SELECT * FROM tb_smp")
    fun getAllSMP(): Flow<List<SMPModel>>

    @Query("SELECT * FROM tb_smp WHERE name LIKE '%' || :search || '%' OR akreditasi LIKE '%' || :search || '%' OR type LIKE '%' || :search || '%'")
    fun getSMPBySearch(search: String): Flow<List<SMPModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSMP(smpModel: SMPModel)

    @Delete
    suspend fun deleteSMP(smpModel: SMPModel)

    //    Kesehatan
    @Query("SELECT * FROM tb_kesehatan")
    fun getAllKesehatan(): Flow<List<KesehatanModel>>

    @Query("SELECT * FROM tb_kesehatan WHERE name LIKE '%' || :search || '%' OR akreditasi = :search OR address LIKE '%' || :search || '%'")
    fun getKesehatanBySearch(search: String): Flow<List<KesehatanModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertKesehatan(kesehatan: KesehatanModel)

    @Delete
    suspend fun deleteKesehatan(kesehatan: KesehatanModel)

    //    Berita
    @Query("SELECT * FROM tb_berita")
    fun getAllBerita(): Flow<List<BeritaModel>>

    @Query("SELECT * FROM tb_berita WHERE name LIKE '%' || :search || '%'  OR type LIKE '%' || :search || '%'")
    fun getBeritaBySearch(search: String): Flow<List<BeritaModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBerita(berita: BeritaModel)

    @Delete
    suspend fun deleteBerita(berita: BeritaModel)

    //    Hoaks
    @Query("SELECT * FROM tb_hoaks")
    fun getAllHoaks(): Flow<List<HoaksModel>>

    @Query("SELECT * FROM tb_hoaks WHERE name LIKE '%' || :search || '%'  OR date LIKE '%' || :search || '%'")
    fun getHoaksBySearch(search: String): Flow<List<HoaksModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHoaks(hoaks: HoaksModel)

    @Delete
    suspend fun deleteHoaks(hoaks: HoaksModel)

    //    Pengumuman
    @Query("SELECT * FROM tb_pengumuman")
    fun getAllPengumuman(): Flow<List<PengumumanModel>>

    @Query("SELECT * FROM tb_pengumuman WHERE name LIKE '%' || :search || '%'  OR date LIKE '%' || :search || '%'")
    fun getPengumumanBySearch(search: String): Flow<List<PengumumanModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPengumuman(hoaks: PengumumanModel)

    @Delete
    suspend fun deletePengumuman(hoaks: PengumumanModel)

    //    Galeri
    @Query("SELECT * FROM tb_galeri")
    fun getAllGaleri(): Flow<List<GaleriModel>>

    @Query("SELECT * FROM tb_galeri WHERE name LIKE '%' || :search || '%'  OR date LIKE '%' || :search || '%'")
    fun getGaleriBySearch(search: String): Flow<List<GaleriModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGaleri(hoaks: GaleriModel)

    @Delete
    suspend fun deleteGaleri(hoaks: GaleriModel)


    //    Magazine
    @Query("SELECT * FROM tb_magazine")
    fun getAllMagazine(): Flow<List<MagazineModel>>

    @Query("SELECT * FROM tb_magazine WHERE name LIKE '%' || :search || '%'")
    fun getMagazineBySearch(search: String): Flow<List<MagazineModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMagazine(hoaks: MagazineModel)

    @Delete
    suspend fun deleteMagazine(hoaks: MagazineModel)

}