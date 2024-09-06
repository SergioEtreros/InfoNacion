package com.minato.countries.network.model


import kotlinx.serialization.Serializable

@Serializable
data class Flags(
   val png: String,
   val svg: String
)