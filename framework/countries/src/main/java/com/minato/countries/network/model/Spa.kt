package com.minato.countries.network.model


import kotlinx.serialization.Serializable

@Serializable
data class Spa(
   val official: String,
   val common: String
)