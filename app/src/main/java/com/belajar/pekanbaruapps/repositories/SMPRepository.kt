package com.belajar.pekanbaruapps.repositories

import com.belajar.pekanbaruapps.database.DatabaseDAO
import com.belajar.pekanbaruapps.model.SMPModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SMPRepository @Inject constructor(private val dao: DatabaseDAO) {
    fun getAllSMP(): Flow<List<SMPModel>> = dao.getAllSMP().flowOn(Dispatchers.IO).conflate()
    fun searchSMP(search:String): Flow<List<SMPModel>> = dao.getSMPBySearch(search).flowOn(
        Dispatchers.IO).conflate()
    suspend fun insertSMP(smpModel: SMPModel) = dao.insertSMP(smpModel)
    suspend fun deleteSMP(smpModel: SMPModel) = dao.deleteSMP(smpModel)
}