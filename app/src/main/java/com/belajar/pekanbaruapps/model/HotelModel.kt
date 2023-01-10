package com.belajar.pekanbaruapps.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "tb_hotel")
data class HotelModel(
    @PrimaryKey
    @ColumnInfo(name = "hotel_name")
    var hotelName:String = "",
    @ColumnInfo(name = "hotel_address")
    var hotelAddress:String? = "",
    @ColumnInfo(name ="hotel_rating")
    var hotelRating:String? = "",
    @ColumnInfo(name = "about_hotel")
    var aboutHotel:String? = "",
    @ColumnInfo(name = "lat")
    var lat:Double? = 0.0,
    @ColumnInfo(name = "long")
    var long:Double? = 0.0,
    @ColumnInfo(name = "image")
    var image:Int? = 0
)
