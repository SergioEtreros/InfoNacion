package com.minato.countries.detail

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.minato.common.InfoNacionScaffold
import com.minato.common.R
import com.minato.common.Result
import com.minato.common.Screen
import com.minato.common.ifSuccess
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
         state = state,
         topBar = {
            state.ifSuccess {
               TopAppBar(
                  title = { Text(it.commonName) },
                  navigationIcon = {
                     IconButton(onClick = onBack) {
                        Icon(
                           imageVector = Icons.AutoMirrored.Default.ArrowBack,
                           contentDescription = stringResource(id = R.string.back)
                        )
                     }
                  },
                  scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
               )
            }
         },
         containerColor = MaterialTheme.colorScheme.surface,
         contentWindowInsets = WindowInsets.statusBars
      ) { paddingValues, country ->

         Box(modifier = Modifier.padding(paddingValues)) {
            CountryDetail(country)
         }
      }
   }
}

@Composable
fun CountryDetail(country: Country) {

   val colors: List<Color> = listOf(
      MaterialTheme.colorScheme.primary,
      MaterialTheme.colorScheme.secondary,
      MaterialTheme.colorScheme.tertiary,
      MaterialTheme.colorScheme.tertiary,
      MaterialTheme.colorScheme.secondary,
      MaterialTheme.colorScheme.primary,
   )
   val brush = Brush.sweepGradient(colors)

   Box(
      modifier = Modifier
         .fillMaxSize()
         .border(2.dp, brush = brush, shape = MaterialTheme.shapes.large)
         .padding(16.dp)
   )
}

@Preview
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
   ) {

   }
}
