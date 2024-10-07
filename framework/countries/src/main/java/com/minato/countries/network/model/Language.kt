package com.minato.countries.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Language(
   val languageCode: String,
   val name: String
)