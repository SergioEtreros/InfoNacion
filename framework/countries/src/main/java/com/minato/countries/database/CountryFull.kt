package com.minato.countries.database

import androidx.room.Embedded
import androidx.room.Relation
import com.minato.countries.database.entities.Borders
import com.minato.countries.database.entities.Country
import com.minato.countries.database.entities.Currencies
import com.minato.countries.database.entities.Languages
import com.minato.countries.database.entities.TimeZones
import com.minato.countries.database.entities.Translations

data class CountryFull(

   @Embedded
   val country: Country,

   @Relation(
      parentColumn = "countryCode",
      entityColumn = "countryCode"
   )
   val currencies: List<Currencies>?,

   @Relation(
      parentColumn = "countryCode",
      entityColumn = "countryCode"
   )
   val languages: List<Languages>?,

   @Relation(
      parentColumn = "countryCode",
      entityColumn = "countryCode"
   )
   val translations: List<Translations>?,

   @Relation(
      parentColumn = "countryCode",
      entityColumn = "countryCode"
   )
   val timezones: List<TimeZones>?,

   @Relation(
      parentColumn = "countryCode",
      entityColumn = "countryCode",
      entity = Borders::class,
   )
   val bordersNames: List<BordersNames>?
)

data class BordersNames(

   @Embedded
   val borders: Borders,

   @Relation(
      parentColumn = "borderCode",
      entityColumn = "countryCode",
      entity = Country::class,
      projection = ["commonName"]
   )
   val country: String
)
