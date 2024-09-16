package com.minato.countries.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.minato.common.R
import com.minato.country.entities.Country

@Composable
fun CountryItem(country: Country, onClick: (Country) -> Unit) {
   Card(modifier = Modifier
      .fillMaxWidth()
      .clickable { onClick(country) }) {
      Row(
         modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
         verticalAlignment = Alignment.CenterVertically
      ) {
         Column(modifier = Modifier.weight(1f)) {
            Text(
               text = country.commonName,
               style = MaterialTheme.typography.headlineMedium,
               fontWeight = FontWeight.Bold

            )
            Text(text = country.continent)
         }
         Spacer(modifier = Modifier.width(8.dp))
         AsyncImage(
            model = country.flag,
            contentDescription = stringResource(id = R.string.flag),
            modifier = Modifier
               .clip(MaterialTheme.shapes.small)
               .width(180.dp)
               .height(120.dp),
            contentScale = ContentScale.FillBounds
         )
      }
   }
}

@Preview(widthDp = 400, heightDp = 200)
@Composable
fun CountryItemPreview() {
   CountryItem(
      Country(
         countryCode = "BR",
         commonName = "Brasil",
         officialName = "Brasileiro",
         capital = "Brasilia",
         region = "America",
         subregion = "America",
         continent = "America",
         flag = "",
         independent = true,
         latitude = 0.0,
         longitude = 0.0,
         population = 0,
         googleMaps = "",
         openStreetMaps = "",
         carSide = "",
         currencies = emptyList(),
         languages = emptyList(),
         translations = emptyList(),
         timeZones = emptyList()
      )
   ) {}
}