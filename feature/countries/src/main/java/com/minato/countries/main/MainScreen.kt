package com.minato.countries.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.minato.common.InfoNacionScaffold
import com.minato.common.R
import com.minato.common.Result
import com.minato.common.Screen
import com.minato.country.entities.Country

@Composable
fun MainScreen(
   model: MainViewmodel = hiltViewModel(),
   onClick: (Country) -> Unit
) {

   val state by model.state.collectAsStateWithLifecycle()

   MainScreen(state, onClick)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
   state: Result<List<Country>>,
   onClick: (Country) -> Unit
) {

   Screen {
      val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
      InfoNacionScaffold(
         state = state,
         topBar = {
            TopAppBar(
               title = {
                  Text(text = stringResource(id = R.string.app_name))
               },
               scrollBehavior = scrollBehavior,
               actions = {
                  IconButton(onClick = {}) {
                     Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = stringResource(id = R.string.current_location)
                     )
                  }
               }
            )
         },
         contentWindowInsets = WindowInsets.safeDrawing
      ) { paddingValues, countries ->
         Box(
            modifier = Modifier
               .fillMaxSize()
               .padding(paddingValues)
         ) {
            CountryList(countries, onClick)
         }
      }
   }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
   MainScreen(Result.Success(emptyList())) { }
}






