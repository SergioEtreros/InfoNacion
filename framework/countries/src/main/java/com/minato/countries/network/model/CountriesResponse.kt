package com.minato.countries.network.model

import com.minato.countries.network.TranslationSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountriesResponse(
   val data: Data
)

@Serializable
data class Data(
   val objects: List<CountryObject>,
   val meta: Meta
)

@Serializable
data class CountryObject(
   val names: Names? = null,
   val codes: Codes? = null,
   val capitals: List<Capitals> = emptyList(),
   val flag: Flag? = null,
   val region: String? = null,
   val subregion: String? = null,
   val area: Area? = null,
   val assets: List<String> = emptyList(),
   val borders: List<String> = emptyList(),
   @SerialName("calling_codes")
   val callingCodes: List<String> = emptyList(),
   val cars: Cars? = null,
   val classification: Classification? = null,
   val continents: List<String> = emptyList(),
   val coordinates: Coordinates? = null,
   val currencies: List<Currencies> = emptyList(),
//   val date: Any? = null,
   val demonyms: Demonyms? = null,
//   val economy: Any? = null,
   @SerialName("government_type")
   val governmentType: String? = null,
   val landlocked: Boolean? = null,
   val languages: List<Languages> = emptyList(),
   val links: Links? = null,
   val memberships: Memberships? = null,
   @SerialName("number_format")
   val numberFormat: NumberFormat? = null,
   val parent: Parent? = null,
   val population: Int? = null,
   val timezones: List<String> = emptyList(),
   val tlds: List<String> = emptyList(),
   val uuid: String? = null,
)

@Serializable
data class Names(
   val alternates: List<String> = emptyList(),
   val common: String?,
   @Serializable(with = TranslationSerializer::class)
   val native: List<Translation>? = emptyList(),
   val official: String?,
   @Serializable(with = TranslationSerializer::class)
   val translations: List<Translation>? = emptyList(),
)

@Serializable
data class Meta(
   val total: Int,
   val count: Int,
   val limit: Int,
   val offset: Int,
   val more: Boolean,
   @SerialName("request_id")
   val requestId: String,
   val duration: Int
)

@Serializable
data class Codes(
   @SerialName("alpha_2")
   val alpha2: String?,
   @SerialName("alpha_3")
   val alpha3: String?,
   val ccn3: String?,
   val cioc: String?,
   val fifa: String?,
   val fips: String?,
   val gec: String?,
)

@Serializable
data class Flag(
   @SerialName("url_png")
   val png: String,
   @SerialName("url_svg")
   val svg: String,
   val description: String?,
)

@Serializable
data class Area(
   val kilometers: Double = 0.0,
   val miles: Double = 0.0,
)

@Serializable
data class Cars(
   val signs: List<String> = emptyList(),
   @SerialName("driving_side")
   val side: String = ""
)

@Serializable
data class Currencies(
   val code: String,
   val name: String,
   val symbol: String
)

@Serializable
data class Coordinates(
   val lat: Double?,
   val lng: Double?,
)

@Serializable
data class Links(
   @SerialName("google_maps")
   val googleMaps: String,
   @SerialName("open_street_maps")
   val openStreetMaps: String
)

@Serializable
data class Parent(
   @SerialName("alpha_2")
   val alpha2: String,
   @SerialName("alpha_3")
   val alpha3: String
)

@Serializable
data class NumberFormat(
   @SerialName("decimal_separator")
   val decimalSeparator: String,
   @SerialName("thousands_separator")
   val thousandsSeparator: String,
)

@Serializable
data class Languages(
   @SerialName("bcp47")
   val bcp47: String,
   @SerialName("iso639_1")
   val iso6391: String,
   @SerialName("iso639_2b")
   val iso6392b: String,
   @SerialName("iso639_2t")
   val iso6392t: String,
   @SerialName("iso639_3")
   val iso6393: String,
   val name: String,
   @SerialName("native_name")
   val nativeName: String,
)

@Serializable
data class Memberships(
   @SerialName("african_union")
   val africanUnion: Boolean,
   @SerialName("arab_league")
   val arabLeague: Boolean,
   val asean: Boolean,
   val brics: Boolean,
   val commonwealth: Boolean,
   val eu: Boolean,
   val eurozone: Boolean,
   val g20: Boolean,
   val g7: Boolean,
   val nato: Boolean,
   val oecd: Boolean,
   val opec: Boolean,
   val schengen: Boolean,
   val un: Boolean
)

@Serializable
data class Classification(
   val dependency: Boolean,
   @SerialName("dependency_type")
   val dependencyType: String,
   val disputed: Boolean,
   @SerialName("iso_status")
   val isoStatus: String,
   val sovereign: Boolean,
   @SerialName("un_member")
   val unMember: Boolean,
   @SerialName("un_observer")
   val unObserver: Boolean,
)

@Serializable
data class Capitals(
   val attributes: Attributes?,
   val coordinates: Coordinates?,
   val name: String,
)

@Serializable
data class Attributes(
   val administrative: Boolean,
   val constitutional: Boolean,
   val executive: Boolean,
   val judicial: Boolean,
   val legislative: Boolean,
   val primary: Boolean,
)


