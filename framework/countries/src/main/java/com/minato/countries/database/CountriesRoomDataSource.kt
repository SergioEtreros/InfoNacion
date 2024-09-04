package com.minato.countries.database

import com.minato.countries.database.dao.CountryDao
import com.minato.country.data.CountryLocalDataSource
import com.minato.country.entities.Country
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CountriesRoomDataSource @Inject constructor(
   private val countryDao: CountryDao
) : CountryLocalDataSource {

   override val countries: Flow<List<Country>>
      get() = TODO("Not yet implemented")

   override fun getCountryById(id: Int): Flow<Country?> {
      TODO("Not yet implemented")
   }

   override fun saveCountry(country: Country) {
      TODO("Not yet implemented")
   }

   override fun saveAllCountries(countries: List<Country>) {
      TODO("Not yet implemented")
   }
}