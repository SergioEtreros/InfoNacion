package com.minato.countries.network

import com.minato.countries.toDomainCountry
import com.minato.country.data.CountryRemoteDataSource
import com.minato.country.entities.Country
import javax.inject.Inject

internal class CountriesServerDataSource @Inject constructor(
   private val countryService: CountryService
) : CountryRemoteDataSource {
   override suspend fun getCountries(): List<Country> {
      try {
         val response = countryService.getCountries()
         return response.map { it.toDomainCountry() }
      } catch (e: Exception) {
         e.printStackTrace()
         return emptyList()
      }
   }

   override suspend fun getCountryByCountryCode(countryCode: String): Country =
      countryService.getCountryByCountryCode(countryCode).first().toDomainCountry()
}

