package com.belajar.pekanbaruapps.repositories

import com.belajar.pekanbaruapps.database.DatabaseDAO
import com.belajar.pekanbaruapps.model.BelanjaModel
import com.belajar.pekanbaruapps.model.HotelModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class BelanjaRepository @Inject constructor(private val dao: DatabaseDAO) {
    fun getAllBelanja(): Flow<List<BelanjaModel>> = dao.getAllPembelanjaan().flowOn(Dispatchers.IO).conflate()
    fun searchBelanja(search:String): Flow<List<BelanjaModel>> = dao.getPembelanjaanBySearch(search).flowOn(Dispatchers.IO).conflate()
    suspend fun insertBelanja(belanjaModel: BelanjaModel) = dao.insertPembelanjaan(belanjaModel)
    suspend fun deleteBelanja(belanjaModel: BelanjaModel) = dao.deletePembelanjaan(belanjaModel)
}