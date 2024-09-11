package com.minato.countries.network.model

import kotlinx.serialization.Serializable

@Serializable
data class CountryItem(
   val name: Name,
   val tld: List<String> = emptyList(),
   val cca2: String,
   val ccn3: String = "",
   val cca3: String,
   val independent: Boolean? = null,
   val status: String,
   val unMember: Boolean,
   val currencies: Currencies? = null,
   val idd: Idd,
   val capital: List<String> = emptyList(),
   val altSpellings: List<String>,
   val region: String,
   val languages: Languages? = null,
   val translations: Translations,
   val latlng: List<Double>,
   val landlocked: Boolean,
   val area: Double,
   val demonyms: Demonyms? = null,
   val flag: String,
   val maps: Maps,
   val population: Int,
   val car: Car,
   val timezones: List<String>,
   val continents: List<String>,
   val flags: Flags,
   val coatOfArms: CoatOfArms,
   val startOfWeek: String,
   val capitalInfo: CapitalInfo
)