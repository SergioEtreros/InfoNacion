package com.minato.feature.countries.detail

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.minato.common.MapLinkButton
import com.minato.common.R
import com.minato.common.theme.strokeBrush
import com.minato.common.theme.topRoundedCornershape
import com.minato.country.entities.Country
import com.minato.feature.countries.dummyCountry
import com.minato.feature.countries.joinToLines
import com.minato.feature.countries.to2Decimal

@Composable
fun GeoDetails(country: Country, mapButtonClicked: (url: String) -> Unit) {

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
            InfoDataItem(title = stringResource(R.string.continent), info = country.continent)
            InfoDataItem(title = stringResource(R.string.region), info = country.region)
            InfoDataItem(title = stringResource(R.string.subregion), info = country.subregion)
            InfoDataItem(title = stringResource(R.string.capital), info = country.capital)

            InfoDataItem(
               title = stringResource(R.string.borders),
               info = country.borders.joinToLines { it })

            InfoDataItem(
               title = stringResource(R.string.coordinates),
               info = "${stringResource(R.string.latitude)}: ${country.latitude.to2Decimal()} - ${
                  stringResource(
                     R.string.longitude
                  )
               }: ${country.longitude.to2Decimal()}"
            )
            InfoDataItem(
               title = stringResource(R.string.timezones),
               info = country.timeZones.joinToLines { it })

            InfoDataItem(
               title = stringResource(R.string.translations),
               info = country.translations.joinToLines { it.official })
         }
      }

      Spacer(modifier = Modifier.height(6.dp))

      Row(
         modifier = Modifier
            .fillWidthOfParent(20.dp)
            .border(2.dp, strokeBrush, topRoundedCornershape)
            .padding(20.dp)
      ) {
         MapLinkButton(
            modifier = Modifier.weight(1f),
            text = stringResource(R.string.google_maps)
         ) { mapButtonClicked(country.googleMaps) }

         Spacer(modifier = Modifier.width(16.dp))

         MapLinkButton(
            modifier = Modifier.weight(1f),
            text = stringResource(R.string.openstreet_maps)
         ) { mapButtonClicked(country.openStreetMaps) }
      }
   }
}

fun Modifier.fillWidthOfParent(parentPadding: Dp) = this.then(
   layout { measurable, constraints ->
      // This is to force layout to go beyond the borders of its parent
      val placeable = measurable.measure(
         constraints.copy(
            maxWidth = constraints.maxWidth + 2 * parentPadding.roundToPx(),
         ),
      )
      layout(placeable.width, placeable.height) {
         placeable.place(0, 0)
      }
   },
)


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GeoDetailsPreview() {
   GeoDetails(dummyCountry) {}
}

