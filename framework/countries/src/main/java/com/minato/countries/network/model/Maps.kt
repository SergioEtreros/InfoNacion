package com.minato.countries.network.model


import kotlinx.serialization.Serializable

@Serializable
data class Maps(
   val googleMaps: String,
   val openStreetMaps: String
)