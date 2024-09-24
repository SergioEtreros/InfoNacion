package com.minato.countries.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
   primaryKeys = ["languageCode", "countryCode"],
   foreignKeys = [ForeignKey(
      entity = Country::class,
      parentColumns = ["countryCode"],
      childColumns = ["countryCode"],
      onDelete = ForeignKey.CASCADE
   )],
   indices = [Index(value = ["countryCode"])]
)
data class Translations(
   val languageCode: String,
   val countryCode: String,
   val official: String,
   val common: String
)
