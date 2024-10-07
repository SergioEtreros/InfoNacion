package com.minato.countries.network.model

import com.minato.countries.network.TranslationSerializer
import kotlinx.serialization.Serializable

@Serializable
data class Name(
   val common: String,
   val official: String,
   @Serializable(with = TranslationSerializer::class)
   val nativeName: List<Translation>? = emptyList()
)