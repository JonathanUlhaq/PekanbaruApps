package com.belajar.pekanbaruapps.di

import android.content.Context
import androidx.room.Room
import com.belajar.pekanbaruapps.database.DatabaseDAO
import com.belajar.pekanbaruapps.database.PekanbaruDatabase
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@dagger.Module
class Module {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): PekanbaruDatabase =
        Room.databaseBuilder(
            context,
            PekanbaruDatabase::class.java,
            "db_app"
        )
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun databaseDAO(database: PekanbaruDatabase): DatabaseDAO = database.dao()
}