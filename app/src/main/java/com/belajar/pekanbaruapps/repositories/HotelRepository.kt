package com.belajar.pekanbaruapps.repositories

import com.belajar.pekanbaruapps.database.DatabaseDAO
import com.belajar.pekanbaruapps.model.HotelModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class HotelRepository @Inject constructor(private val dao: DatabaseDAO) {
    fun getAllHotel():Flow<List<HotelModel>> = dao.getAllHotel().flowOn(Dispatchers.IO).conflate()
    fun searchHotel(search:String):Flow<List<HotelModel>> = dao.searchHotel(search).flowOn(Dispatchers.IO).conflate()
    suspend fun insertHotel(hotelModel: HotelModel) = dao.insertHotel(hotelModel)
    suspend fun deleteHotel(hotelModel: HotelModel) = dao.deleteHotel(hotelModel)
}