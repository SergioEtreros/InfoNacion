package com.minato.infonacion.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.minato.common.Detail
import com.minato.common.Main
import com.minato.feature.countries.detail.DetailScreen
import com.minato.feature.countries.main.MainScreen

@Composable
fun Navigation() {

   val navController = rememberNavController()

   NavHost(navController = navController, startDestination = Main) {
      composable<Main> {
         MainScreen { country ->
            navController.navigate(Detail(country.countryCode))
         }
      }

      composable<Detail> {
         DetailScreen(
            onBack = { navController.popBackStack() }
         )
      }
   }
}