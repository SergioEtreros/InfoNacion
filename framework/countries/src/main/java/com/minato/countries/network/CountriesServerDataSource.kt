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

   override suspend fun getCountryByCountryCode(countryCode: String): Country =
      countryService.getCountryByCountryCode(countryCode).first().toDomainCountry()
}

private fun CountryItem.toDomainCountry() = Country(
   countryCode = cca2,
   commonName = name.common,
   officialName = name.official,
   capital = capital.firstOrNull() ?: "",
   region = region,
   subregion = subRegion,
   continent = continents.firstOrNull() ?: "",
   flag = flags.png,
   independent = independent,
   latitude = latlng.firstOrNull() ?: 0.0,
   longitude = latlng.lastOrNull() ?: 0.0,
   population = population,
   googleMaps = maps.googleMaps,
   openStreetMaps = maps.openStreetMaps,
   carSide = car.side,
   currencies = emptyList(),
   languages = emptyList(),
   translations = emptyList(),
   timeZones = timezones,
)