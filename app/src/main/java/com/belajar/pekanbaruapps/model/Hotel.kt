package com.belajar.pekanbaruapps.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "tb_hotel")
data class Hotel(
    @PrimaryKey
    @ColumnInfo(name = "hotel_name")
    val hotelName:String,
    @ColumnInfo(name = "hotel_address")
    val hotelAddress:String,
    @ColumnInfo(name ="hotel_rating")
    val hotelRating:Int,
    @ColumnInfo(name = "about_hotel")
    val aboutHotel:String,
    @ColumnInfo(name = "lat")
    val lat:Double,
    @ColumnInfo(name = "long")
    val long:Double,
    @Ignore var overview: String
)