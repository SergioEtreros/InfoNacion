package com.minato.country.data

import com.minato.country.entities.Country
import kotlinx.coroutines.flow.Flow

interface CountryLocalDataSource {
   val countries: Flow<List<Country>>
   fun getCountryByName(name: String): Flow<Country?>
   suspend fun saveCountry(country: Country)
   suspend fun saveAllCountries(countries: List<Country>)
}