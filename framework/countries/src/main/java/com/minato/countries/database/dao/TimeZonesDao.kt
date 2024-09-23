package com.minato.countries.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.minato.countries.database.entities.TimeZones

@Dao
interface TimeZonesDao {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertTimeZones(timeZones: List<TimeZones>)

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertTimezone(timezone: TimeZones)
}