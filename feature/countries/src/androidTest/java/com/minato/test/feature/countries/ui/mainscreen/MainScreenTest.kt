package com.minato.test.feature.countries.ui.mainscreen

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.minato.common.LOADING_INDICATOR_TEST_TAG
import com.minato.common.LOCATION_BUTTON_TEST_TAG
import com.minato.common.Result
import com.minato.country.entities.Country
import com.minato.feature.countries.main.MainScreen
import com.minato.unit.domain.country.sampleCountries
import com.minato.unit.domain.country.sampleCountry
import org.junit.Rule
import org.junit.Test

class MainScreenTest {

   @get:Rule
   val composeTestRule = createComposeRule()

   @Test
   fun whenLoadingShowsLoading(): Unit = with(composeTestRule) {

      setContent {
         MainScreen(
            state = Result.Loading,
            onItemClick = { country -> },
            onLocationClick = { }
         )
      }

      onNodeWithTag(LOADING_INDICATOR_TEST_TAG).assertExists()
   }

   @Test
   fun whenErrorShowsError(): Unit = with(composeTestRule) {

      setContent {
         MainScreen(
            state = Result.Error(RuntimeException("Something went wrong")),
            onItemClick = { country -> },
            onLocationClick = { }
         )
      }

      onNodeWithText("Something went wrong").assertExists()
   }

   @Test
   fun whenSuccessShowsList(): Unit = with(composeTestRule) {

      setContent {
         MainScreen(
            state = Result.Success(sampleCountries("aaa", "bbb", "ccc")),
            onItemClick = { country -> },
            onLocationClick = { }
         )
      }

      onNodeWithText("aaa name").assertExists()
   }

   @Test
   fun whenItemClick_listenerIsCalled(): Unit = with(composeTestRule) {
      var clickedCountry: Country? = null

      val countries = sampleCountries("aaa", "bbb", "ccc")

      setContent {
         MainScreen(
            state = Result.Success(countries),
            onItemClick = { country -> clickedCountry = country },
            onLocationClick = { }
         )
      }

      onNodeWithText("aaa name").performClick()

      assert(clickedCountry == sampleCountry("aaa"))
   }

   @Test
   fun whenLocationClick_listenerIsCalled(): Unit = with(composeTestRule) {
      var clicked = false

      val countries = sampleCountries("aaa", "bbb", "ccc")

      setContent {
         MainScreen(
            state = Result.Success(countries),
            onItemClick = { country -> },
            onLocationClick = { clicked = true }
         )
      }

      onNodeWithTag(LOCATION_BUTTON_TEST_TAG).performClick()

      assert(clicked)
   }
}