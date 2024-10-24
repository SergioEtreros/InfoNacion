package com.minato.feature.countries.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.minato.common.GradientStrokeShape
import com.minato.common.ObliqueCustomShape
import com.minato.common.R
import com.minato.country.entities.Country
import com.minato.feature.countries.dummyCountry

@Composable
fun CountryItem(country: Country, onClick: (Country) -> Unit) {

   GradientStrokeShape(
      modifier = Modifier
         .clipToBounds()
         .width(160.dp)
         .height(160.dp),
      shape = ObliqueCustomShape(30.dp, 20.dp),
      onCardClick = { onClick(country) }
   ) {
      AsyncImage(
         model = country.flag,
         contentDescription = stringResource(id = R.string.flag),
         modifier = Modifier.fillMaxSize(),
         contentScale = ContentScale.Crop
      )

      Box(
         modifier = Modifier
            .alpha(0.6f)
            .background(Color.Black)
      )

      Column(
         modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp),
         verticalArrangement = Arrangement.Center
      ) {
         Text(
            text = country.commonName,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
         )
         Text(text = country.continent)
      }
   }
}

@Preview(widthDp = 400, heightDp = 200)
@Composable
fun CountryItemPreview() {
   CountryItem(dummyCountry) {}
}