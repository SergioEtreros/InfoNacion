package com.minato.countries.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
         }
      ) { paddingValues, country ->

         Box(modifier = Modifier.padding(paddingValues)) {
            CountryDetail(country)
         }
      }
   }
}

@Composable
fun CountryDetail(country: Country) {

}
