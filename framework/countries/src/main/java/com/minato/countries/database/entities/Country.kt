package com.minato.countries.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Country(
   @PrimaryKey
   val countryCode: String,
   val commonName: String,
   val officialName: String,
   val capital: String,
   val region: String,
   val subregion: String,
   val continent: String,
   val flag: String,
   val independent: Boolean?,
   val latitude: Double,
   val longitude: Double,
   val population: Int,
   val googleMaps: String,
   val openStreetMaps: String,
   val carSide: String,
)