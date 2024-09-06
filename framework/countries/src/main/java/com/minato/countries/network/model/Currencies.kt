package com.minato.countries.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Currencies(
   @SerialName("SHP")
   val sHP: SHP
)