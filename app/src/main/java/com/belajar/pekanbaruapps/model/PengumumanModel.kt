package com.belajar.pekanbaruapps.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_pengumuman")
data class PengumumanModel(
    @PrimaryKey
    @ColumnInfo(name = "name")
    var name:String = "",

    @ColumnInfo(name = "image")
    val image:Int? = 0,

    @ColumnInfo(name = "date")
    var date:String? = "",

    @ColumnInfo(name = "view")
    var view:String? = ""
)
