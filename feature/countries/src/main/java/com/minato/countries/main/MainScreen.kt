package com.minato.countries.main

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.minato.common.Screen
import com.minato.country.entities.Country

@Composable
fun MainScreen(onClick: (Country) -> Unit) {
   Screen {
      Text("Hola mundo")
   }
}