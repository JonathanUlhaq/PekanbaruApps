package com.belajar.pekanbaruapps.repositories

import com.belajar.pekanbaruapps.database.DatabaseDAO
import com.belajar.pekanbaruapps.model.RestaurantModel
import com.belajar.pekanbaruapps.model.SDModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SDRepository @Inject constructor(private val dao:DatabaseDAO) {
    fun getAllSD(): Flow<List<SDModel>> = dao.getAllSD().flowOn(Dispatchers.IO).conflate()
    fun searchSD(search:String): Flow<List<SDModel>> = dao.getSDBySearch(search).flowOn(
        Dispatchers.IO).conflate()
    suspend fun insertSD(sdModel: SDModel) = dao.insertSD(sdModel)
    suspend fun deleteSD(sdModel: SDModel) = dao.deleteSD(sdModel)
}