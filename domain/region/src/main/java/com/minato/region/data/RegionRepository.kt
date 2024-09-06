package com.minato.region.data

import javax.inject.Inject

class RegionRepository @Inject constructor(private val dataSource: RegionDataSource) {
   suspend fun getLastRegion(): String = dataSource.getLastRegion()
}