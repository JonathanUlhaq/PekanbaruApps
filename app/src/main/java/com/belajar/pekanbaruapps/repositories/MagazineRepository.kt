package com.belajar.pekanbaruapps.repositories

import com.belajar.pekanbaruapps.database.DatabaseDAO
import com.belajar.pekanbaruapps.model.MagazineModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MagazineRepository @Inject constructor(private val dao: DatabaseDAO) {
    fun getAllMagazine(): Flow<List<MagazineModel>> = dao.getAllMagazine().flowOn(Dispatchers.IO).conflate()
    fun searchMagazine(search:String): Flow<List<MagazineModel>> = dao.getMagazineBySearch(search).flowOn(
        Dispatchers.IO).conflate()
    suspend fun insertMagazine(smpModel: MagazineModel) = dao.insertMagazine(smpModel)
    suspend fun deleteMagazine(smpModel: MagazineModel) = dao.deleteMagazine(smpModel)
}