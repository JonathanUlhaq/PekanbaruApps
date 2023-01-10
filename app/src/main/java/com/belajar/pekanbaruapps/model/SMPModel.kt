package com.belajar.pekanbaruapps.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_smp")
data class SMPModel(
    @PrimaryKey
    @ColumnInfo(name = "name")
    var name:String = "",

    @ColumnInfo(name = "type")
    var type:String? = "",

    @ColumnInfo(name = "akreditasi")
    var akreditasi:String? = "",

    @ColumnInfo(name = "address")
    var address:String? = "",

    @ColumnInfo(name = "image")
    var image:Int? = 0,

    @ColumnInfo(name = "phone")
    var phone:String? = "",

    @ColumnInfo(name = "lat")
    var lat:Double? = 0.0,

    @ColumnInfo(name = "long")
    var long:Double? = 0.0,

    @ColumnInfo(name = "about")
    var about:String? = ""
)
