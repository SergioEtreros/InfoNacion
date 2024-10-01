package com.minato.feature.countries.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.minato.common.theme.blueLinearBrushText
import com.minato.common.theme.greyLinearBrush
import com.minato.common.theme.strokeBrush
import com.minato.common.theme.topRoundedCornershape
import com.minato.country.entities.Country
import com.minato.feature.countries.dummyCountry

@Composable
fun DetailsBlock(country: Country, mapButtonClicked: (url: String) -> Unit) {
   Box(
      modifier = Modifier
         .fillMaxSize()
         .shadow(10.dp, topRoundedCornershape)
         .border(2.dp, strokeBrush, topRoundedCornershape)
         .background(greyLinearBrush, topRoundedCornershape)
         .padding(20.dp),
   ) {

      var active by remember { mutableIntStateOf(0) }
      val activeTextStyle = TextStyle(
         brush = blueLinearBrushText,
         fontWeight = FontWeight.Bold
      )

      Column {
         Row {
            DetailButton(
               modifier = Modifier.weight(1f),
               onClick = { active = 0 }, active = active == 0
            ) {
               Text(
                  text = "Geográficos",
                  style = if (active == 0) activeTextStyle else TextStyle(
                     color = (Color(
                        0x99FFFFFF
                     ))
                  ),
               )
            }

            Spacer(modifier = Modifier.width(8.dp))

            DetailButton(
               modifier = Modifier.weight(1f),
               onClick = { active = 1 }, active = active == 1
            ) {
               Text(
                  text = "Socioeconomicos",
                  style = if (active == 1) activeTextStyle else TextStyle(
                     color = (Color(
                        0x99FFFFFF
                     ))
                  ),
               )
            }
         }

         when (active) {
            0 -> GeoDetails(country) { url -> mapButtonClicked(url) }
            1 -> EcoSocialDetails(country)
         }
      }
   }
}

@Preview
@Composable
fun DetailsBlockPreview() {
   DetailsBlock(country = dummyCountry) {}
}