package com.minato.unit.data

import com.minato.country.data.CountryLocalDataSource
import com.minato.country.data.CountryRemoteDataSource
import com.minato.country.data.CountryRepository
import com.minato.country.entities.Country
import com.minato.map.data.GoogleMapsDataSource
import com.minato.map.data.MapRepository
import com.minato.map.data.OpenStreetMapDataSource
import com.minato.region.data.RegionDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map

fun buildCountriesRepositoryWith(
   localData: List<Country>,
   remoteData: List<Country>
): CountryRepository {
   val countryLocalDataSource = FakeLocalDataSource(localData)
   val countryRemoteDataSource = FakeRemoteDataSource(remoteData)
   return CountryRepository(countryLocalDataSource, countryRemoteDataSource)
}

class FakeRegionDataSource(private val lastRegion: String) : RegionDataSource {
   override suspend fun getLastRegion(): String = lastRegion
}

class FakeLocalDataSource(countries: List<Country> = emptyList()) : CountryLocalDataSource {

   private val inMemoryCountries = MutableStateFlow(countries)

   override val countries: Flow<List<Country>> = inMemoryCountries

   override fun getCountryByCountryCode(countryCode: String): Flow<Country?> =
      inMemoryCountries.map { it.firstOrNull { country -> country.countryCode == countryCode } }

   override suspend fun saveCountry(country: Country) {
   }

   override suspend fun saveAllCountries(countries: List<Country>) {
      inMemoryCountries.value = countries
   }
}

class FakeRemoteDataSource(private val countries: List<Country>) : CountryRemoteDataSource {
   override suspend fun getCountries(): List<Country> = countries

   override suspend fun getCountryByCountryCode(countryCode: String) =
      countries.first { it.countryCode == countryCode }
}

fun buildMapRepository() = MapRepository(FakeGoogleMapsDataSource(), FakeOpenStreetMapsDataSource())

class FakeGoogleMapsDataSource : GoogleMapsDataSource {
   override suspend fun openMap(url: String) {}
}

class FakeOpenStreetMapsDataSource : OpenStreetMapDataSource {
   override suspend fun openMap(url: String) {}
}