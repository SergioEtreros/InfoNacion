package com.minato.countries.detail

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.minato.common.InfoNacionScaffold
import com.minato.common.R
import com.minato.common.Result
import com.minato.common.Screen
import com.minato.common.ifSuccess
import com.minato.common.theme.blueLinearBrushButton
import com.minato.common.theme.blueLinearBrushShape
import com.minato.common.theme.greyLinearBrush
import com.minato.common.theme.strokeBrush
import com.minato.common.theme.trapezoidShape
import com.minato.country.entities.Country

@Composable
fun DetailScreen(
   model: DetailViewmodel = hiltViewModel(),
   onBack: () -> Unit
) {

   val state by model.state.collectAsStateWithLifecycle()

   DetailScreen(
      state = state,
      onBack = onBack
   )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
   state: Result<Country>,
   onBack: () -> Unit
) {
   Screen {

      InfoNacionScaffold(
//         modifier = Modifier.background(blueLinearBrush, trapezoidShape),
         state = state,
         topBar = {
            state.ifSuccess {
               CenterAlignedTopAppBar(
                  title = {
                     Text(
                        text = it.commonName,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                     )
                  },
                  navigationIcon = {
                     IconButton(
                        modifier = Modifier
                           .padding(start = 20.dp)
                           .background(
                              blueLinearBrushButton, RoundedCornerShape(size = 10.dp)
                           ),
                        onClick = onBack
                     ) {
                        Icon(
                           imageVector = Icons.AutoMirrored.Default.ArrowBack,
                           contentDescription = stringResource(id = R.string.back)
                        )
                     }
                  },
                  scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(),
                  colors = TopAppBarDefaults.topAppBarColors().copy(
                     containerColor = Color.Transparent,
                  )
               )
            }
         },
         containerColor = MaterialTheme.colorScheme.surface,
         contentWindowInsets = WindowInsets.statusBars
      ) { paddingValues, country ->

         Box(
            modifier = Modifier
               .background(blueLinearBrushShape, trapezoidShape)
               .padding(paddingValues)
         ) {
            CountryDetail(country)
         }
      }
   }
}

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

      val shape = RoundedCornerShape(
         topStart = 50.dp,
         topEnd = 50.dp,
         bottomEnd = 0.dp,
         bottomStart = 0.dp,
      )

      Box(
         modifier = Modifier
            .fillMaxSize()
            .shadow(10.dp, shape)
            .border(2.dp, strokeBrush, shape)
            .background(greyLinearBrush, shape)

            .padding(horizontal = 20.dp, vertical = 20.dp),
      ) {
         Text(text = country.commonName)
      }
   }

}

@Preview(
   heightDp = 400,
   widthDp = 400,
   showBackground = true,
   uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun TrapPrevioew() {
   Box(
      modifier = Modifier
         .padding(40.dp)
//         .size(200.dp)
         .border(2.dp, color = Color.Black)
         .background(blueLinearBrushShape, trapezoidShape)
   ) {

   }
}

@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CountryDetailPreview() {

   DetailScreen(
      state = Result.Success(
         Country(
            countryCode = "BR",
            commonName = "Brasil",
            officialName = "Brasileiro",
            capital = "Brasilia",
            region = "America",
            subregion = "America",
            continent = "America",
            flag = "https://flagcdn.com/w320/br.png",
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
      )
   ) {}
}
