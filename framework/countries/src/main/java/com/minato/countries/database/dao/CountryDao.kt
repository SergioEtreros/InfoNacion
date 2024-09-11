package com.minato.countries.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.minato.countries.database.CountryFull
import com.minato.countries.database.entities.Country
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {

   @Query("Select * from country")
   fun getCountries(): Flow<List<Country>>

   @Transaction
   @Query(
      """
      Select c.*, cu.*, l.*, t.*, tz.*, b.* from country as c
      join currencies as cu on c.countryCode = cu.countryCode
      join languages as l on l.countryCode = c.countryCode
      join translations as t on t.countryCode = c.countryCode
      join timezones as tz on tz.countryCode = c.countryCode
      join borders as b on b.countryCode = c.countryCode
      where c.countryCode = :countryCode
   """
   )
   fun getCountryByCountryCode(countryCode: String): Flow<CountryFull?>

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertCountry(country: Country)

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertAllCountries(countries: List<Country>)
}