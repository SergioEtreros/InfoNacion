package com.minato.countries.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.minato.countries.database.entities.Currencies

@Dao
interface CurrenciesDao {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertcurrency(currency: Currencies)

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertcurrencies(currencies: List<Currencies>)
}