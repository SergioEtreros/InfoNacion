package com.minato.region.data

import com.minato.region.entities.Location

interface LocationDataSource {
   suspend fun getLastLocation(): Location?
}