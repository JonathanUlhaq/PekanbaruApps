package com.belajar.pekanbaruapps.repositories

import com.belajar.pekanbaruapps.database.DatabaseDAO
import com.belajar.pekanbaruapps.model.KesehatanModel
import com.belajar.pekanbaruapps.model.SMPModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class KesehatanRepository @Inject constructor(private val dao: DatabaseDAO) {
    fun getAllKesehatan(): Flow<List<KesehatanModel>> = dao.getAllKesehatan().flowOn(Dispatchers.IO).conflate()
    fun searchKesehatan(search:String): Flow<List<KesehatanModel>> = dao.getKesehatanBySearch(search).flowOn(
        Dispatchers.IO).conflate()
    suspend fun insertKesehatan(kesehatan: KesehatanModel) = dao.insertKesehatan(kesehatan)
    suspend fun deleteKesehatan(kesehatan: KesehatanModel) = dao.deleteKesehatan(kesehatan)
}