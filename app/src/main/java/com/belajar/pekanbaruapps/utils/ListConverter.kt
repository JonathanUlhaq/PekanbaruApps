package com.belajar.pekanbaruapps.utils

import android.content.ClipData
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListConverter {
    @TypeConverter
    fun toStringArrayList(value: String): List<String> {
        val itemType = object : TypeToken<List<String>>() {}.type
       return Gson().fromJson<List<String>>(value,itemType)
    }

    @TypeConverter
    fun fromStringArrayList(value: List<String>): String {

        return Gson().toJson(value)
    }

}