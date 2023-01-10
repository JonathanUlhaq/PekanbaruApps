package com.belajar.pekanbaruapps.repositories

import com.belajar.pekanbaruapps.database.DatabaseDAO
import com.belajar.pekanbaruapps.model.BeritaModel
import com.belajar.pekanbaruapps.model.HoaksModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HoaksRepository @Inject constructor(private val dao: DatabaseDAO) {
    fun getAllHoaks(): Flow<List<HoaksModel>> = dao.getAllHoaks().flowOn(Dispatchers.IO).conflate()
    fun searchHoaks(search:String): Flow<List<HoaksModel>> = dao.getHoaksBySearch(search).flowOn(
        Dispatchers.IO).conflate()
    suspend fun insertHoaks(belanjaModel: HoaksModel) = dao.insertHoaks(belanjaModel)
    suspend fun deleteHoaks(belanjaModel: HoaksModel) = dao.deleteHoaks(belanjaModel)
}