package com.minato.region.data

const val DEFAULT_REGION = "ES"

interface RegionDataSource {
   suspend fun getLastRegion(): String
}