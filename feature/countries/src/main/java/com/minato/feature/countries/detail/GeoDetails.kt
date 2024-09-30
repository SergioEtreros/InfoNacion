package com.minato.feature.countries.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.minato.country.entities.Country
import com.minato.feature.countries.dummyCountry

@Composable
fun GeoDetails(country: Country) {
   Column(
      modifier = Modifier
         .fillMaxSize()
         .verticalScroll(rememberScrollState())
   ) {
      Text(text = country.continent)
      Text(text = country.region)
      Text(text = country.subregion)
      Text(text = country.capital)
      Text(text = "Borders:")
      country.borders.forEach {
         Text(text = "\t$it")
      }
      Text(text = "${country.latitude} - ${country.longitude}")
      Text(text = "Timezones:")
      country.timeZones.forEach {
         Text(text = "\t$it")
      }
      Text(text = "Translations:")
      country.translations.forEach {
         Text(text = "${it.languageCode} - ${it.official}")
      }

      TextButton({}) {
         Text(text = country.googleMaps)
      }

      TextButton({}) {
         Text(text = country.openStreetMaps)
      }
   }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GeoDetailsPreview() {
   GeoDetails(dummyCountry)
}