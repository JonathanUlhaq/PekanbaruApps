package com.belajar.pekanbaruapps.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.belajar.pekanbaruapps.model.*
import com.belajar.pekanbaruapps.utils.ListConverter

@Database(
    entities = [
        HotelModel::class,
        RestaurantModel::class,
        WisataModel::class,
        BelanjaModel::class,
        SDModel::class,
        SMPModel::class,
        KesehatanModel::class,
        BeritaModel::class,
        HoaksModel::class,
        MagazineModel::class,
        GaleriModel::class,
        PengumumanModel::class],
    version = 25
)
@TypeConverters(ListConverter::class)
abstract class PekanbaruDatabase : RoomDatabase() {
    abstract fun dao(): DatabaseDAO
}