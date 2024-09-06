package com.minato.countries.network.model


import kotlinx.serialization.Serializable

@Serializable
data class Name(
   val common: String,
   val official: String,
   val nativeName: NativeName
)