package com.minato.countries.network.model

import kotlinx.serialization.Serializable

@Serializable
data class CapitalInfo(
   val latlng: List<Double> = emptyList()
)