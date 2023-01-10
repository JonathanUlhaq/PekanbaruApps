package com.belajar.pekanbaruapps.repositories

import com.belajar.pekanbaruapps.database.DatabaseDAO
import com.belajar.pekanbaruapps.model.GaleriModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GaleriRepository @Inject constructor(private val dao: DatabaseDAO) {
    fun getAllGaleri(): Flow<List<GaleriModel>> = dao.getAllGaleri().flowOn(Dispatchers.IO).conflate()
    fun searchGaleri(search:String): Flow<List<GaleriModel>> = dao.getGaleriBySearch(search).flowOn(
        Dispatchers.IO).conflate()
    suspend fun insertGaleri(smpModel: GaleriModel) = dao.insertGaleri(smpModel)
    suspend fun deleteGaleri(smpModel: GaleriModel) = dao.deleteGaleri(smpModel)
}