package com.minato.countries.network.model


import kotlinx.serialization.Serializable

@Serializable
data class RemoteResultCountry(
   val name: Name,
   val tld: List<String>,
   val cca2: String,
   val ccn3: String,
   val cca3: String,
   val independent: Boolean,
   val status: String,
   val unMember: Boolean,
   val currencies: Currencies,
   val idd: Idd,
   val capital: List<String>,
   val altSpellings: List<String>,
   val region: String,
   val languages: Languages,
   val translations: Translations,
   val latlng: List<Double>,
   val landlocked: Boolean,
   val area: Int,
   val demonyms: Demonyms,
   val flag: String,
   val maps: Maps,
   val population: Int,
   val car: Car,
   val timezones: List<String>,
   val continents: List<String>,
   val flags: Flags,
   val coatOfArms: CoatOfArms?,
   val startOfWeek: String,
   val capitalInfo: CapitalInfo
)