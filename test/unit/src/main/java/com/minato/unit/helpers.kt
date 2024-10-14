package com.minato.unit

import com.minato.country.entities.Country

fun sampleCountry(countryCode: String) = Country(
   countryCode = countryCode,
   cca3 = "$countryCode cca3",
   commonName = "$countryCode name",
   officialName = "$countryCode official name",
   capital = "$countryCode capital",
   region = "$countryCode region",
   subregion = "$countryCode subregion",
   continent = "$countryCode continent",
   flag = "$countryCode flag url",
   independent = true,
   latitude = 0.0,
   longitude = 0.0,
   population = 123456,
   googleMaps = "",
   openStreetMaps = "",
   carSide = "right",
   currencies = emptyList(),
   languages = emptyList(),
   translations = emptyList(),
   timeZones = emptyList(),
   borders = emptyList()
)

fun sampleCountries(vararg codes: String) = codes.map { sampleCountry(it) }