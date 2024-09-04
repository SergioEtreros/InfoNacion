package com.minato.country.data

import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class CountryRepository @Inject constructor(
   private val localDataSource: CountryLocalDataSource,
   private val remoteDataSource: CountryRemoteDataSource
) {
   val countries = localDataSource.countries.onEach { localCountries ->
      if (localCountries.isEmpty()) {
         val remoteCountries = remoteDataSource.getCountries()
         localDataSource.saveAllCountries(remoteCountries)
      }
   }

   fun getCountryById(id: Int) = localDataSource.getCountryById(id).onEach { localCountry ->
      if (localCountry == null) {
         val remoteCountry = remoteDataSource.getCountryById(id)
         localDataSource.saveCountry(remoteCountry)
      }
   }
}