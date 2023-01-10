package com.belajar.pekanbaruapps.repositories

import com.belajar.pekanbaruapps.database.DatabaseDAO
import com.belajar.pekanbaruapps.model.HotelModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DetailHotelRepository @Inject constructor(private val dao:DatabaseDAO) {
    fun getHotelByName(name:String):Flow<HotelModel> = dao.hotelByName(name).flowOn(Dispatchers.IO).conflate()
}