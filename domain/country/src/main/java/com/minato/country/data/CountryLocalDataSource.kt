package com.minato.country.data

import com.minato.country.entities.Country
import kotlinx.coroutines.flow.Flow

interface CountryLocalDataSource {
   val countries: Flow<List<Country>>
   fun getCountryById(id: Int): Flow<Country?>
   fun saveCountry(country: Country)
   fun saveAllCountries(countries: List<Country>)
}