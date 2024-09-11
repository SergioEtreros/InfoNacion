package com.minato.countries.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Car(
   val signs: List<String> = emptyList(),
   val side: String = ""
)