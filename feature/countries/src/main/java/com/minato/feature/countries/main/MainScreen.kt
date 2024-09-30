package com.minato.feature.countries.main

import android.Manifest
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.minato.common.InfoNacionScaffold
import com.minato.common.LocateButton
import com.minato.common.R
import com.minato.common.Result
import com.minato.common.Screen
import com.minato.country.entities.Country

@Composable
fun MainScreen(
   model: MainViewmodel = hiltViewModel(),
   onItemClick: (Country) -> Unit
) {

   val state by model.state.collectAsStateWithLifecycle()
   val context = LocalContext.current

   val permissionLauncher =
      rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
         if (granted) {
            model.getActualCountry { country ->
               onItemClick(country)
            }
         } else {
            Toast.makeText(
               context,
               "Se necesitan permisos de ubicación",
               Toast.LENGTH_LONG
            ).show()
         }
      }

   MainScreen(
      state = state,
      onItemClick = onItemClick,
      onLocationClick = { permissionLauncher.launch(Manifest.permission.ACCESS_COARSE_LOCATION) }
   )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
   state: Result<List<Country>>,
   onItemClick: (Country) -> Unit,
   onLocationClick: () -> Unit
) {

   Screen {
      val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
      InfoNacionScaffold(
         state = state,
         topBar = {
            TopAppBar(
               title = { Text(text = stringResource(id = R.string.app_name)) },
               scrollBehavior = scrollBehavior,
               actions = { LocateButton(onLocationClick) }
            )
         },
         contentColor = MaterialTheme.colorScheme.onSurface,
         containerColor = MaterialTheme.colorScheme.surface,
         contentWindowInsets = WindowInsets.statusBars
      ) { paddingValues, countries ->
         Box(
            modifier = Modifier
               .fillMaxSize()
               .padding(paddingValues)
         ) {
            CountryList(countries, onItemClick)
         }
      }
   }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
   MainScreen(Result.Success(emptyList()), {}, {})
}

