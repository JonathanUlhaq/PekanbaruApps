package com.belajar.pekanbaruapps.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "belanja_tb")
data class BelanjaModel(
    @PrimaryKey
    @ColumnInfo(name = "name")
    var nama:String = "",

    @ColumnInfo(name = "address")
    var address:String? = "",

    @ColumnInfo(name = "openHour")
    var openHour:String? = "",

    @ColumnInfo(name = "phone")
    var phone:String? = "",

    @ColumnInfo(name = "lat")
    var lat:Double? = 0.0,

    @ColumnInfo(name = "long")
    var long:Double? = 0.0,

    @ColumnInfo(name = "about")
    var about:String? = "",

    @ColumnInfo(name = "image")
    var image:Int? = 0
)
