package com.minato.map.data

interface OpenStreetMapDataSource {
   suspend fun openMap(url: String)
}