package com.belajar.pekanbaruapps.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_restaurant")
data class RestaurantModel(
    @PrimaryKey
    @ColumnInfo(name = "nama")
    var name:String = "",

    @ColumnInfo(name = "image")
    var image:Int? = 0,

    @ColumnInfo(name = "address")
    var address:String? = "",

    @ColumnInfo(name = "kecamatan")
    var kecamatan:String? = "",

    @ColumnInfo(name = "lat")
    var lat:Double? =  0.0,

    @ColumnInfo(name = "long")
    var long:Double? = 0.0,

    @ColumnInfo(name ="description")
    var desc:String? = "",

    @ColumnInfo(name = "open_hour")
    var openHour:String? = "",

    @ColumnInfo(name = "phone")
    var phone:String? = ""
)
