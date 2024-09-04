package com.minato.core

import androidx.room.Database
import androidx.room.RoomDatabase
import com.minato.countries.database.dao.CountryDao
import com.minato.countries.database.entities.Country

@Database(
   entities = [Country::class],
   version = 1,
   exportSchema = true,
   autoMigrations = []
)
abstract class CountryDb : RoomDatabase() {
   abstract fun countryDao(): CountryDao
}