package com.minato.region.usecases

import com.minato.region.data.RegionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetLastRegionUseCase @Inject constructor(
   private val repository: RegionRepository
) {
   suspend operator fun invoke() = withContext(Dispatchers.IO) { repository.getLastRegion() }
}