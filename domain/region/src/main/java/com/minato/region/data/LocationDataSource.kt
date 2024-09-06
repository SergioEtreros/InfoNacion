package com.minato.region.data

interface LocationDataSource {
   suspend fun getLastLocation(): String
}