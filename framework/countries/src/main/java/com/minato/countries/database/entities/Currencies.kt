package com.minato.countries.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
   primaryKeys = ["currencyCode", "countryCode"],
   foreignKeys = [
      ForeignKey(
      entity = Country::class,
      parentColumns = ["countryCode"],
      childColumns = ["countryCode"],
      onDelete = ForeignKey.CASCADE
   )],
   indices = [Index(value = ["countryCode"]), Index(value = ["currencyCode"])]
)
data class Currencies(
   val currencyCode: String,
   val countryCode: String,
   val name: String,
   val symbol: String
)
