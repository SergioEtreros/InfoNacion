package com.minato.feature.countries.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.minato.common.MapLinkButton
import com.minato.country.entities.Country
import com.minato.feature.countries.dummyCountry
import com.minato.feature.countries.joinToLines

@Composable
fun GeoDetails(country: Country) {

   Column(
      modifier = Modifier
         .padding(vertical = 8.dp)
   ) {
      Box(
         modifier = Modifier.weight(1f)
      ) {
         Column(
            modifier = Modifier

               .fillMaxSize()
               .verticalScroll(rememberScrollState())

         ) {
            InfoDataItem(title = "Continent", info = country.continent)
            InfoDataItem(title = "Region", info = country.region)
            InfoDataItem(title = "Subregion", info = country.subregion)
            InfoDataItem(title = "Capital", info = country.capital)

            InfoDataItem(title = "Borders", info = country.borders.joinToLines { it })

            InfoDataItem(
               title = "Coordinates",
               info = "Latitude: ${country.latitude} - Longitude: ${country.longitude}"
            )
            InfoDataItem(title = "Timezones:", info = country.timeZones.joinToLines { it })

            InfoDataItem(
               title = "Translations",
               info = country.translations.joinToLines { it.official })
         }
      }

      Spacer(modifier = Modifier.height(16.dp))

      Row(
         modifier = Modifier
            .fillMaxWidth()
      ) {
         MapLinkButton(
            modifier = Modifier.weight(1f),
            text = "Google Maps"
         ) { }

         Spacer(modifier = Modifier.width(16.dp))

         MapLinkButton(
            modifier = Modifier.weight(1f),
            text = "OpenStreetMaps"
         ) { }
      }
   }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GeoDetailsPreview() {
   GeoDetails(dummyCountry)
}

