package com.belajar.pekanbaruapps.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_magazine")
data class MagazineModel(
    @PrimaryKey
    @ColumnInfo(name = "name")
    var name:String = "",

    @ColumnInfo(name = "image")
    var image:Int? = 0
)
