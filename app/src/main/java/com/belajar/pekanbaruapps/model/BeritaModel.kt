package com.belajar.pekanbaruapps.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_berita")
data class BeritaModel (
    @PrimaryKey
    @ColumnInfo(name = "name")
    var name:String = "",

    @ColumnInfo(name = "type")
    var type:List<String>? = listOf(""),

    @ColumnInfo(name = "date")
    var date:String? = "",

    @ColumnInfo(name = "view")
    var view:String? = "",

    @ColumnInfo(name = "desc")
    var desc:String? = "",

    @ColumnInfo(name = "image")
    var image:Int? = 0
        )