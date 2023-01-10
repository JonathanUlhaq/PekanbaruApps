package com.belajar.pekanbaruapps.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wisata_tb")
data class WisataModel(
    @PrimaryKey
    @ColumnInfo(name = "name")
    var name:String = "",
    @ColumnInfo(name = "type")
    var type:String? = "",
    @ColumnInfo(name = "address")
    var address:String? = "",
    @ColumnInfo(name = "openHour")
    var openHour:String? = "",
    @ColumnInfo(name = "image")
    var image:Int? = 0,
    @ColumnInfo(name = "phone")
    var phone:String? = "",
    @ColumnInfo(name = "about")
    var about:String? = "",
    @ColumnInfo(name = "lat")
    var lat:Double? = 0.0,
    @ColumnInfo(name = "long")
    var long:Double? = 0.0,

)