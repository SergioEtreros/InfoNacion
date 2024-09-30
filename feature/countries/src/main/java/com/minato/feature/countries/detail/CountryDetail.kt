package com.minato.feature.countries.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.minato.common.R
import com.minato.country.entities.Country
import com.minato.feature.countries.dummyCountry

@Composable
fun CountryDetail(country: Country) {
   Column(
      modifier = Modifier
         .fillMaxSize(),
      horizontalAlignment = Alignment.CenterHorizontally
   ) {
      AsyncImage(
         model = country.flag,
         contentDescription = stringResource(id = R.string.flag),
         modifier = Modifier
            .padding(top = 20.dp, bottom = 50.dp)
            .clip(RoundedCornerShape(24.dp))
            .height(150.dp)
            .wrapContentWidth(),
         contentScale = ContentScale.FillHeight
      )

      DetailsBlock(country)
   }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CountryDetailPreview() {
   CountryDetail(dummyCountry)
}