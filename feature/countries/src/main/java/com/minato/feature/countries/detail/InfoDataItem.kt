package com.minato.feature.countries.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InfoDataItem(title: String, info: String) {

   Column(
      modifier = Modifier
         .fillMaxWidth()
         .padding(top = 16.dp)
   ) {
      Text(
         fontWeight = FontWeight.Bold,
         color = Color.White,
         fontSize = 17.sp,
         text = title
      )

      val locale = Locale.current
      Text(
         text = info.capitalize(locale).takeIf { it.isNotBlank() } ?: "N/A",
         color = Color(0x99FFFFFF),
         fontSize = 15.sp,
      )
   }
}

@Preview(showBackground = true)
@Composable
fun InfoDataItemPreview() {
   InfoDataItem(title = "Region", info = "Africa")
}