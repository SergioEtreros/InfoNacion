package com.minato.countries.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Currency(
   val name: String,
   val symbol: String
)