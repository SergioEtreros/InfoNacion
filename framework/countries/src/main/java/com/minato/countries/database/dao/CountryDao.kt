package com.minato.countries.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.minato.countries.database.entities.Country
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {

   @Query("Select * from country")
   fun getCountries(): Flow<List<Country>>

   @Query("Select * from country where name = :name")
   fun getCountryByName(name: String): Flow<Country?>

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertCountry(country: Country)

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertAllCountries(countries: List<Country>)
}