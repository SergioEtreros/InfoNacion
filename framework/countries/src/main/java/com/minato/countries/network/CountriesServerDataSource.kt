package com.minato.countries.network

import com.minato.country.data.CountryRemoteDataSource
import com.minato.country.entities.Country
import javax.inject.Inject

class CountriesServerDataSource @Inject constructor(
   private val countryService: CountryService
) : CountryRemoteDataSource {
   override fun getCountries(): List<Country> {
      TODO("Not yet implemented")
   }

   override fun getCountryById(id: Int): Country {
      TODO("Not yet implemented")
   }
}