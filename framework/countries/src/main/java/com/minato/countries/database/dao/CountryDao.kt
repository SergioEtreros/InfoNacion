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

   @Query("Select * from country order by commonName")
   fun getCountries(): Flow<List<Country>>

   @Transaction
   @Query("Select * from country where countryCode = :countryCode")
   fun getCountryByCountryCode(countryCode: String): Flow<CountryFull?>

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertCountry(country: Country)

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertAllCountries(countries: List<Country>)
}