package com.minato.countries.network.model

import android.annotation.SuppressLint
import com.minato.countries.network.CurrencySerializer
import com.minato.countries.network.LanguageSerializer
import com.minato.countries.network.TranslationSerializer
import kotlinx.serialization.Serializable

@SuppressLint("UnsafeOptInUsageError")
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
   @Serializable(with = CurrencySerializer::class)
   val currencies: List<Currency> = emptyList(),
   val idd: Idd,
   val capital: List<String> = emptyList(),
   val altSpellings: List<String>,
   val region: String,
   val subRegion: String = "",
   @Serializable(with = LanguageSerializer::class)
   val languages: List<Language> = emptyList(),
   @Serializable(with = TranslationSerializer::class)
   val translations: List<Translation>,
   val latlng: List<Double>,
   val landlocked: Boolean,
   val borders: List<String> = emptyList(),
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