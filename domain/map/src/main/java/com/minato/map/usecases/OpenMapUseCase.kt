package com.minato.map.usecases

import com.minato.map.data.MapRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OpenMapUseCase @Inject constructor(
   private val mapRepository: MapRepository
) {
   suspend operator fun invoke(url: String) =
      withContext(Dispatchers.Default) { mapRepository.openMap(url) }
}