package com.minato.region.usecases

import com.minato.region.data.RegionRepository
import javax.inject.Inject

class GetLastRegionUseCase @Inject constructor(
   private val repository: RegionRepository
) {
   suspend operator fun invoke() = repository.getLastRegion()
}