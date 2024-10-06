package com.minato.map.data

interface GoogleMapsDataSource {
   suspend fun openMap(url: String)
}