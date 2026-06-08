package com.minato.countries.network.model

import com.minato.countries.network.CurrencySerializer
import com.minato.countries.network.LanguageSerializer
import com.minato.countries.network.TranslationSerializer
import kotlinx.serialization.Serializable

@Serializable
data class CountryItem(
   val name: Name,
   val tld: List<String> = emptyList(),
   val cca2: String,
   val ccn3: String = "",
   val cca3: String,
   val independent: Boolean? = null,
   val status: String = "",
   val unMember: Boolean? = null,
   @Serializable(with = CurrencySerializer::class)
   val currencies: List<Currency> = emptyList(),
   val idd: Idd? = null,
   val capital: List<String> = emptyList(),
   val altSpellings: List<String> = emptyList(),
   val region: String = "",
   val subRegion: String = "",
   @Serializable(with = LanguageSerializer::class)
   val languages: List<Language> = emptyList(),
   @Serializable(with = TranslationSerializer::class)
   val translations: List<Translation> = emptyList(),
   val latlng: List<Double>? = emptyList(),
   val landlocked: Boolean? = null,
   val borders: List<String> = emptyList(),
   val area: Double = 0.0,
   val demonyms: Demonyms? = null,
   val flag: String = "",
   val maps: Maps? = null,
   val population: Int = 0,
   val car: Car? = null,
   val timezones: List<String> = emptyList(),
   val continents: List<String> = emptyList(),
   val flags: Flags,
   val coatOfArms: CoatOfArms? = null,
   val startOfWeek: String = "",
   val capitalInfo: CapitalInfo? = null
)