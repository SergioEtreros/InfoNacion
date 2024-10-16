package com.minato.countries.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Currency(
   val currencyCode: String,
   val name: String,
   val symbol: String
)