package com.belajar.pekanbaruapps.repositories

import com.belajar.pekanbaruapps.database.DatabaseDAO
import com.belajar.pekanbaruapps.model.BelanjaModel
import com.belajar.pekanbaruapps.model.BeritaModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class BeritaRepository @Inject constructor(private val dao: DatabaseDAO) {
    fun getAllBerita(): Flow<List<BeritaModel>> = dao.getAllBerita().flowOn(Dispatchers.IO).conflate()
    fun searchBerita(search:String): Flow<List<BeritaModel>> = dao.getBeritaBySearch(search).flowOn(
        Dispatchers.IO).conflate()
    suspend fun insertBerita(belanjaModel: BeritaModel) = dao.insertBerita(belanjaModel)
    suspend fun deleteBerita(belanjaModel: BeritaModel) = dao.deleteBerita(belanjaModel)
}