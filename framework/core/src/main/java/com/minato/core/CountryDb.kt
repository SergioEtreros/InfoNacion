package com.minato.core

import androidx.room.Database
import androidx.room.RoomDatabase
import com.minato.countries.database.dao.CountryDao
import com.minato.countries.database.entities.Borders
import com.minato.countries.database.entities.Country
import com.minato.countries.database.entities.Currencies
import com.minato.countries.database.entities.Languages
import com.minato.countries.database.entities.TimeZones
import com.minato.countries.database.entities.Translations

@Database(
   entities = [
      Country::class,
      Borders::class,
      Currencies::class,
      Languages::class,
      TimeZones::class,
      Translations::class
   ],
   version = 1,
   exportSchema = true,
   autoMigrations = []
)
abstract class CountryDb : RoomDatabase() {
   abstract fun countryDao(): CountryDao
}