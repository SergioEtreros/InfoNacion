package com.minato.countries.network.model


import kotlinx.serialization.Serializable

@Serializable
data class Idd(
   val root: String,
   val suffixes: List<String>
)