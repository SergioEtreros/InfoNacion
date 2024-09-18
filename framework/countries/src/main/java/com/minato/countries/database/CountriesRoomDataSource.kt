package com.minato.countries.database

import com.minato.countries.database.dao.CountryDao
import com.minato.country.data.CountryLocalDataSource
import com.minato.country.entities.Country
import com.minato.country.entities.Currency
import com.minato.country.entities.Languaje
import com.minato.country.entities.Translation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import com.minato.countries.database.entities.Country as DatabaseCountry

class CountriesRoomDataSource @Inject constructor(
   private val countryDao: CountryDao
) : CountryLocalDataSource {

   override val countries: Flow<List<Country>>
      get() = countryDao.getCountries()
         .map { it.map { countryFull -> countryFull.toDomainCountry() } }

   override fun getCountryByCountryCode(countryCode: String) =
      countryDao.getCountryByCountryCode(countryCode).map { it?.toDomainCountry() }

   override suspend fun saveCountry(country: Country) =
      countryDao.insertCountry(country.toDbModel())

   override suspend fun saveAllCountries(countries: List<Country>) {
      countryDao.insertAllCountries(countries.map { it.toDbModel() })
   }
}

private fun DatabaseCountry.toDomainCountry() = Country(
   countryCode = countryCode,
   commonName = commonName,
   officialName = officialName,
   capital = capital,
   region = region,
   subregion = subregion,
   continent = continent,
   flag = flag,
   independent = independent,
   latitude = latitude,
   longitude = longitude,
   population = population,
   googleMaps = googleMaps,
   openStreetMaps = openStreetMaps,
   carSide = carSide,
   currencies = emptyList(),
   languages = emptyList(),
   translations = emptyList(),
   timeZones = emptyList(),
)

private fun CountryFull.toDomainCountry() = Country(
   countryCode = country.countryCode,
   commonName = country.commonName,
   officialName = country.officialName,
   capital = country.capital,
   region = country.region,
   subregion = country.subregion,
   continent = country.continent,
   flag = country.flag,
   independent = country.independent,
   latitude = country.latitude,
   longitude = country.longitude,
   population = country.population,
   googleMaps = country.googleMaps,
   openStreetMaps = country.openStreetMaps,
   carSide = country.carSide,
   currencies = currencies?.map { Currency(it.name, it.symbol) } ?: emptyList(),
   languages = languages?.map { Languaje(it.languageCode, it.name) } ?: emptyList(),
   translations = translations?.map { Translation(it.languageCode, it.official, it.common) }
      ?: emptyList(),
   timeZones = timezones?.map { it.timeZone } ?: emptyList(),

   )

private fun Country.toDbModel() = DatabaseCountry(
   countryCode = countryCode,
   commonName = commonName,
   officialName = officialName,
   capital = capital,
   region = region,
   subregion = subregion,
   continent = continent,
   flag = flag,
   independent = independent,
   latitude = latitude,
   longitude = longitude,
   population = population,
   googleMaps = googleMaps,
   openStreetMaps = openStreetMaps,
   carSide = carSide
)