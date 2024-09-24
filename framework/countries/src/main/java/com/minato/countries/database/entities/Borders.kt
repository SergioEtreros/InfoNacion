package com.minato.countries.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
   primaryKeys = ["countryCode", "borderCode"],
   foreignKeys = [ForeignKey(
      entity = Country::class,
      parentColumns = ["countryCode"],
      childColumns = ["countryCode"],
      onDelete = ForeignKey.CASCADE
   )],
   indices = [Index(value = ["countryCode"]), Index(value = ["borderCode"])]
)
data class Borders(
   val countryCode: String,
   val borderCode: String
)
