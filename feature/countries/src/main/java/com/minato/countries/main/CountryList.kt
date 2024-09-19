package com.minato.countries.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.minato.country.entities.Country

@Composable
fun CountryList(countries: List<Country>, onClick: (Country) -> Unit) {
   LazyVerticalGrid(
      columns = GridCells.Fixed(2),
      modifier = Modifier.fillMaxSize(),
      contentPadding = PaddingValues(8.dp),
      horizontalArrangement = Arrangement.spacedBy(20.dp),
//      verticalArrangement = Arrangement.spacedBy(2.dp)
   ) {
      items(countries, key = { it.countryCode }) { country ->
         CountryItem(country, onClick)
      }
   }
}