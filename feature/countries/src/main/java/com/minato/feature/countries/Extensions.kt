package com.minato.feature.countries

import com.minato.country.entities.Country

val dummyCountry = Country(
   countryCode = "BR",
   commonName = "Brasil",
   officialName = "Brasileiro",
   capital = "Brasilia",
   region = "America",
   subregion = "America",
   continent = "America",
   flag = "https://flagcdn.com/w320/br.png",
   independent = true,
   latitude = 32.5,
   longitude = -43.0,
   population = 4345340,
   googleMaps = "",
   openStreetMaps = "",
   carSide = "left",
   currencies = emptyList(),
   languages = emptyList(),
   translations = emptyList(),
   timeZones = emptyList(),
   borders = emptyList()
)

fun Int.format(): String = "%,d".format(this)

fun <T> Iterable<T>.joinToLines(
   separator: CharSequence = "\n",
   prefix: CharSequence = "",
   postfix: CharSequence = "",
   limit: Int = -1,
   truncated: CharSequence = "...",
   transform: ((T) -> CharSequence)? = null
): String {
   return joinTo(
      StringBuilder(),
      separator,
      prefix,
      postfix,
      limit,
      truncated,
      transform
   ).toString()
}