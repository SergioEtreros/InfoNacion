package com.minato.feature.countries.detail

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.minato.common.BackButton
import com.minato.common.InfoNacionScaffold
import com.minato.common.Result
import com.minato.common.Screen
import com.minato.common.ifSuccess
import com.minato.common.theme.blueLinearBrushShape
import com.minato.common.theme.trapezoidShape
import com.minato.country.entities.Country
import com.minato.feature.countries.dummyCountry

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
               CenterAlignedTopAppBar(
                  title = {
                     Text(
                        text = it.commonName,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                     )
                  },
                  navigationIcon = { BackButton(onBack) },
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

@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DetailScreenPreview() {

   DetailScreen(state = Result.Success(dummyCountry)) {}
}


