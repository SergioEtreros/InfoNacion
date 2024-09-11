package com.minato.countries.network

import com.minato.countries.network.model.CountryItem
import com.minato.country.data.CountryRemoteDataSource
import com.minato.country.entities.Country
import javax.inject.Inject

internal class CountriesServerDataSource @Inject constructor(
   private val countryService: CountryService
) : CountryRemoteDataSource {
   override suspend fun getCountries(): List<Country> {
      val response = countryService.getCountries()
      return response.map { it.toDomainCountry() }
   }

   override suspend fun getCountryByName(name: String): Country =
      countryService.getCountryByName(name).first().toDomainCountry()
}

private fun CountryItem.toDomainCountry() = Country(
   name = name.common
)