package com.minato.country.entities

data class Country(
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
   val currencies: List<Currency>,
   val languages: List<Languaje>,
   val translations: List<Translation>,
   val timeZones: List<String>,
)