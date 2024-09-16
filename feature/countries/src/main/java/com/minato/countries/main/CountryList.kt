package com.minato.countries.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.minato.country.entities.Country

@Composable
fun CountryList(countries: List<Country>, onClick: (Country) -> Unit) {
   LazyColumn(
      modifier = Modifier.fillMaxSize(),
      contentPadding = PaddingValues(8.dp),
      verticalArrangement = Arrangement.spacedBy(8.dp)
   ) {
      items(countries, key = { it.countryCode }) { country ->
         CountryItem(country, onClick)
      }
   }
}