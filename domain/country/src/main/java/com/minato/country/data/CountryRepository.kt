package com.minato.country.data

import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class CountryRepository @Inject constructor(
   private val localDataSource: CountryLocalDataSource,
   private val remoteDataSource: CountryRemoteDataSource
) {
   val countries
      get() = localDataSource.countries.onEach { localCountries ->
         if (localCountries.isEmpty()) {
            val remoteCountries = remoteDataSource.getCountries()
            localDataSource.saveAllCountries(remoteCountries)
         }
      }

   fun getCountryByCountryCode(countryCode: String) =
      localDataSource.getCountryByCountryCode(countryCode).onEach { localCountry ->
         if (localCountry == null) {
            val remoteCountry = remoteDataSource.getCountryByCountryCode(countryCode)
            localDataSource.saveCountry(remoteCountry)
         }
      }.filterNotNull()
}