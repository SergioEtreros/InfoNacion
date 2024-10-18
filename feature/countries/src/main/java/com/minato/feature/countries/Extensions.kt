package com.minato.feature.countries

import android.content.Context
import com.minato.common.R
import com.minato.country.entities.Country
import kotlin.math.roundToInt

val dummyCountry = Country(
   countryCode = "BR",
   cca3 = "BRA",
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

fun Double.to2Decimal() = (this * 100).roundToInt() / 100.0

fun Boolean?.toNaturalText(context: Context): String =
   if (this == null) context.getString(R.string.n_a) else
      if (this) context.getString(R.string.yes) else context.getString(R.string.no)

fun String?.toNaturalText(context: Context): String =
   if (this == null) context.getString(R.string.n_a) else
      if (this.lowercase().trim() == "left")
         context.getString(R.string.left_side)
      else
         context.getString(R.string.right_side)