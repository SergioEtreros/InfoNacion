package com.minato.countries

import com.minato.countries.database.CountryFull
import com.minato.countries.network.model.CountryItem
import com.minato.country.entities.Country
import com.minato.country.entities.Currency
import com.minato.country.entities.Language
import com.minato.country.entities.Translation
import com.minato.countries.database.entities.Country as DatabaseCountry
import com.minato.countries.database.entities.Currencies as DatabaseCurrencies
import com.minato.countries.database.entities.Languages as DatabaseLanguages
import com.minato.countries.database.entities.Translations as DatabaseTranslations
import com.minato.countries.network.model.Currency as NetworkCurrency
import com.minato.countries.network.model.Language as NetworkLanguage
import com.minato.countries.network.model.Translation as NetworkTranslation

fun Currency.toDbModel(countryCode: String) = DatabaseCurrencies(
   currencyCode = code,
   countryCode = countryCode,
   name = name,
   symbol = symbol
)

fun Language.toDbModel(countryCode: String) = DatabaseLanguages(
   languageCode = languageCode,
   countryCode = countryCode,
   name = name,
)

fun Translation.toDbModel(countryCode: String) = DatabaseTranslations(
   languageCode = languageCode,
   countryCode = countryCode,
   official = official,
   common = common
)

fun DatabaseCountry.toDomainCountry() = Country(
   countryCode = countryCode,
   cca3 = cca3,
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
   borders = emptyList()
)

fun CountryFull.toDomainCountry() = Country(
   countryCode = country.countryCode,
   cca3 = country.cca3,
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
   currencies = currencies?.map { Currency(it.currencyCode, it.name, it.symbol) } ?: emptyList(),
   languages = languages?.map { Language(it.languageCode, it.name) } ?: emptyList(),
   translations = translations?.map { Translation(it.languageCode, it.official, it.common) }
      ?: emptyList(),
   timeZones = timezones?.map { it.timeZone } ?: emptyList(),
   borders = bordersNames?.map { it.country } ?: emptyList()
)

fun Country.toDbModel() = DatabaseCountry(
   countryCode = countryCode,
   cca3 = cca3,
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

fun CountryItem.toDomainCountry() = Country(
   countryCode = cca2,
   cca3 = cca3,
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
   currencies = currencies.map { it.toDomainCurrency() },
   languages = languages.map { it.toDomainLanguage() },
   translations = translations.map { it.toDomainTranslation() },
   timeZones = timezones,
   borders = borders
)

private fun NetworkTranslation.toDomainTranslation(): Translation =
   Translation(languageCode = languageCode, official = official, common = common)

private fun NetworkLanguage.toDomainLanguage(): Language =
   Language(languageCode = languageCode, name = name)

private fun NetworkCurrency.toDomainCurrency(): Currency =
   Currency(code = currencyCode, name = name, symbol = symbol)