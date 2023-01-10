package com.belajar.pekanbaruapps.repositories

import com.belajar.pekanbaruapps.database.DatabaseDAO
import com.belajar.pekanbaruapps.model.RestaurantModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RestaurantRepository @Inject constructor(private val dao:DatabaseDAO) {
    fun getAllRestaurant():Flow<List<RestaurantModel>> = dao.getAllRestaurant().flowOn(Dispatchers.IO).conflate()
    fun searchRestaurant(search:String):Flow<List<RestaurantModel>> = dao.getRestaurantBySearch(search).flowOn(Dispatchers.IO).conflate()
    suspend fun insertRestaurant(restaurantModel: RestaurantModel) = dao.insertRestaurant(restaurantModel)
    suspend fun deleteRestaurant(restaurantModel: RestaurantModel) = dao.deleteRestaurant(restaurantModel)
}