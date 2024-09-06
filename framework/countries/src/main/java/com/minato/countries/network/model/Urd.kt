package com.minato.countries.network.model


import kotlinx.serialization.Serializable

@Serializable
data class Urd(
   val official: String,
   val common: String
)