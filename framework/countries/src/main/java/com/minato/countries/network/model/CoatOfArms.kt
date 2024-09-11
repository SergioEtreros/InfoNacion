package com.minato.countries.network.model

import kotlinx.serialization.Serializable

@Serializable
data class CoatOfArms(
   val png: String? = null,
   val svg: String? = null
)