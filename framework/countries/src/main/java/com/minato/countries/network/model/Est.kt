package com.minato.countries.network.model


import kotlinx.serialization.Serializable

@Serializable
data class Est(
   val official: String,
   val common: String
)