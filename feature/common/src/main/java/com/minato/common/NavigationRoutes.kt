package com.minato.common

import kotlinx.serialization.Serializable

@Serializable
object Main

@Serializable
data class Detail(val countryName: String)