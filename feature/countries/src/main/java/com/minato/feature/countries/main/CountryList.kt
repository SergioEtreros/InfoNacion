package com.minato.feature.countries.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.minato.country.entities.Country

@Composable
fun CountryList(countries: List<Country>, onClick: (Country) -> Unit) {

   LazyVerticalGrid(
      columns = GridCells.Adaptive(160.dp),
      modifier = Modifier.fillMaxSize(),
      contentPadding = PaddingValues(
         top = 8.dp,
         start = 16.dp,
         end = 16.dp,
         bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding() + 8.dp
      ),
      state = rememberLazyGridState(),
      horizontalArrangement = Arrangement.spacedBy(20.dp),
   ) {
      items(countries, key = { it.countryCode }) { country ->
         CountryItem(country, onClick)
      }
   }
}