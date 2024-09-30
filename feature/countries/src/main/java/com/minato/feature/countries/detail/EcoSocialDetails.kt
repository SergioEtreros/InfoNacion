package com.minato.feature.countries.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.minato.country.entities.Country
import com.minato.feature.countries.dummyCountry

@Composable
fun EcoSocialDetails(country: Country) {
   Column(
      modifier = Modifier
         .fillMaxSize()
         .verticalScroll(rememberScrollState())
   ) {
      Text(text = country.population.toString())
      Text(text = country.carSide)
      Text(text = country.independent.toString())

      Text(text = "Currencies:")
      country.currencies.forEach {
         Text(text = "${it.code} - ${it.name} - ${it.symbol}")
      }
   }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SocialDetailsPreview() {
   EcoSocialDetails(country = dummyCountry)
}