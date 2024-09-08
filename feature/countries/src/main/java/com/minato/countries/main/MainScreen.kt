package com.minato.countries.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.minato.common.InfoNacionScaffold
import com.minato.common.Result
import com.minato.common.Screen
import com.minato.countries.R
import com.minato.country.entities.Country

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(onClick: (Country) -> Unit) {

   val state = Result.Success(listOf(
      Country(1, "España"),
      Country(2, "Japón")
   ))
   val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

   Screen {
      InfoNacionScaffold(
         state = state,
         topBar = {
            TopAppBar(
               title = {
                  Text(text = "InfoNacion")
//                  Text(text = stringResource(id = R.string.title))
               },
               scrollBehavior = scrollBehavior
            )
         },
         contentWindowInsets = WindowInsets.safeDrawing
      ) { paddingValues, countries ->
         Box(
            modifier = Modifier
               .fillMaxSize()
               .padding(paddingValues)
//               .padding(4.dp)
         ) {
            CountryList(countries, onClick)
         }
      }
   }
}

@Composable
fun CountryList(countries: List<Country>, onClick: (Country) -> Unit) {
   LazyColumn(
      modifier = Modifier.fillMaxSize(),
      contentPadding = PaddingValues(8.dp),
      verticalArrangement = Arrangement.spacedBy(6.dp)
   ) {
      items(countries, key = { it.id }) { country ->
         CountryItem(country, onClick)
      }
   }
}

@Composable
fun CountryItem(country: Country, onClick: (Country) -> Unit) {
   Card(modifier = Modifier
      .fillMaxWidth()
      .clickable { onClick(country) }) {
      Column(modifier = Modifier.padding(8.dp)) {
         Text(text = "${country.id}")
         Text(text = country.name)
      }
   }
}

@Preview
@Composable
fun MainScreenPreview() {
   MainScreen {}
}
