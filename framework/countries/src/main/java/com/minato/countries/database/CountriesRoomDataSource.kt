package com.minato.countries.database

import com.minato.countries.database.dao.CountryDao
import com.minato.country.data.CountryLocalDataSource
import com.minato.country.entities.Country
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import com.minato.countries.database.entities.Country as DatabaseCountry

class CountriesRoomDataSource @Inject constructor(
   private val countryDao: CountryDao
) : CountryLocalDataSource {

   override val countries: Flow<List<Country>>
      get() = countryDao.getCountries().map { it.map { country -> country.toDomainCountry() } }

   override fun getCountryByName(name: String) =
      countryDao.getCountryByName(name).map { it?.toDomainCountry() }

   override suspend fun saveCountry(country: Country) =
      countryDao.insertCountry(country.toDbModel())

   override suspend fun saveAllCountries(countries: List<Country>) {
      TODO("Not yet implemented")
   }
}

private fun DatabaseCountry.toDomainCountry() = Country(name = name)
private fun Country.toDbModel() = DatabaseCountry(id = id, name = name)