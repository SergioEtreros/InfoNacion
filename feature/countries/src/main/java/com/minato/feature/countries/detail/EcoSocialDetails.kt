package com.minato.feature.countries.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.minato.country.entities.Country
import com.minato.feature.countries.dummyCountry
import com.minato.feature.countries.format
import com.minato.feature.countries.joinToLines

@Composable
fun EcoSocialDetails(country: Country) {
   Column(
      modifier = Modifier
         .fillMaxSize()
         .verticalScroll(rememberScrollState())
         .padding(top = 8.dp)
   ) {
      InfoDataItem(title = "Population", info = country.population.format())

      val currencies = country.currencies.joinToLines { "${it.name} - Symbol: ${it.symbol}" }
      InfoDataItem(title = "Currencies", info = currencies)

      val languajes = country.languages.joinToLines { it.name }
      InfoDataItem(title = "Languages", info = languajes)

      InfoDataItem(title = "Car Side", info = country.carSide)
      InfoDataItem(title = "Independent", info = country.independent.toString())
   }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SocialDetailsPreview() {
   EcoSocialDetails(country = dummyCountry)
}

