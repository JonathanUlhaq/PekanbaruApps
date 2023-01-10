package com.belajar.pekanbaruapps.repositories

import com.belajar.pekanbaruapps.database.DatabaseDAO
import com.belajar.pekanbaruapps.model.PengumumanModel
import com.belajar.pekanbaruapps.model.SMPModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PengumumanRepository @Inject constructor(private val dao: DatabaseDAO) {
    fun getAllPengumuman(): Flow<List<PengumumanModel>> = dao.getAllPengumuman().flowOn(Dispatchers.IO).conflate()
    fun searchPengumuman(search:String): Flow<List<PengumumanModel>> = dao.getPengumumanBySearch(search).flowOn(
        Dispatchers.IO).conflate()
    suspend fun insertPengumuman(smpModel: PengumumanModel) = dao.insertPengumuman(smpModel)
    suspend fun deletePengumuman(smpModel: PengumumanModel) = dao.deletePengumuman(smpModel)
}