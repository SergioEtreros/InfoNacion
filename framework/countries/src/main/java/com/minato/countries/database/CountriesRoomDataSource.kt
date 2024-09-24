package com.minato.countries.database

import com.minato.countries.database.dao.BordersDao
import com.minato.countries.database.dao.CountryDao
import com.minato.countries.database.dao.CurrenciesDao
import com.minato.countries.database.dao.LanguagesDao
import com.minato.countries.database.dao.TimeZonesDao
import com.minato.countries.database.dao.TranslationsDao
import com.minato.countries.database.entities.Borders
import com.minato.countries.database.entities.TimeZones
import com.minato.countries.toDbModel
import com.minato.countries.toDomainCountry
import com.minato.country.data.CountryLocalDataSource
import com.minato.country.entities.Country
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CountriesRoomDataSource @Inject constructor(
   private val countryDao: CountryDao,
   private val currenciesDao: CurrenciesDao,
   private val languagesDao: LanguagesDao,
   private val translationsDao: TranslationsDao,
   private val timeZonesDao: TimeZonesDao,
   private val bordersDao: BordersDao
) : CountryLocalDataSource {

   override val countries: Flow<List<Country>>
      get() = countryDao.getCountries()
         .map { it.map { countryFull -> countryFull.toDomainCountry() } }

   override fun getCountryByCountryCode(countryCode: String) =
      countryDao.getCountryByCountryCode(countryCode).map { it?.toDomainCountry() }

   override suspend fun saveCountry(country: Country) {
      countryDao.insertCountry(country.toDbModel())
      saveCountryDetails(country)
   }


   override suspend fun saveAllCountries(countries: List<Country>) {
      countryDao.insertAllCountries(countries.map { it.toDbModel() })
      countries.forEach { country -> saveCountryDetails(country) }
   }

   private suspend fun saveCountryDetails(country: Country) {
      currenciesDao.insertcurrencies(country.currencies.map { it.toDbModel(country.countryCode) })
      languagesDao.insertlanguages(country.languages.map { it.toDbModel(country.countryCode) })
      translationsDao.insertTranslations(country.translations.map { it.toDbModel(country.countryCode) })
      timeZonesDao.insertTimeZones(country.timeZones.map {
         TimeZones(
            id = 0,
            timeZone = it,
            countryCode = country.countryCode
         )
      })
      bordersDao.insertBorders(country.borders.map {
         Borders(
            countryCode = country.countryCode,
            borderCode = it
         )
      })
   }
}

