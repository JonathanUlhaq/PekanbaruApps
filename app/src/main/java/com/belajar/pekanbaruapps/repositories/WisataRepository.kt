package com.belajar.pekanbaruapps.repositories

import com.belajar.pekanbaruapps.database.DatabaseDAO
import com.belajar.pekanbaruapps.model.WisataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class WisataRepository @Inject constructor(private val dao: DatabaseDAO) {
    fun getAllWisata():Flow<List<WisataModel>> = dao.getAllWisata().flowOn(Dispatchers.IO).conflate()
    fun getWisatabySearch(search:String):Flow<List<WisataModel>> = dao.getWisataBySearch(search).flowOn(Dispatchers.IO).conflate()
    suspend fun insertWisata(wisataModel: WisataModel) = dao.insertWisata(wisataModel)
    suspend fun deleteWisata(wisataModel: WisataModel) = dao.deleteWisata(wisataModel)
}