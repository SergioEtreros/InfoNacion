package com.minato.countries.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
   foreignKeys = [ForeignKey(
      entity = Country::class,
      parentColumns = ["countryCode"],
      childColumns = ["countryCode"],
      onDelete = ForeignKey.CASCADE
   )],
   indices = [Index(value = ["countryCode"])]
)
data class Translations(
   @PrimaryKey
   val languageCode: String,
   val countryCode: String,
   val official: String,
   val common: String
)