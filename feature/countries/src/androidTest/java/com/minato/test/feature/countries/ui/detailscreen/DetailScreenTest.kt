package com.minato.test.feature.countries.ui.detailscreen

import androidx.annotation.StringRes
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import com.minato.common.BACK_BUTTON_TEST_TAG
import com.minato.common.LOADING_INDICATOR_TEST_TAG
import com.minato.common.R
import com.minato.common.Result
import com.minato.feature.countries.detail.DetailScreen
import com.minato.unit.domain.country.sampleCountry
import org.junit.Rule
import org.junit.Test

class DetailScreenTest {

   @get:Rule
   val composeTestRule = createComposeRule()

   @Test
   fun whenLoadingShowsLoading(): Unit = with(composeTestRule) {

      setContent {
         DetailScreen(
            state = Result.Loading,
            mapButtonClicked = { url -> },
            onBack = { }
         )
      }

      onNodeWithTag(LOADING_INDICATOR_TEST_TAG).assertExists()
   }

   @Test
   fun whenErrorShowsError(): Unit = with(composeTestRule) {

      setContent {
         DetailScreen(
            state = Result.Error(RuntimeException("Something went wrong")),
            mapButtonClicked = { url -> },
            onBack = { }
         )
      }

      onNodeWithText("Something went wrong").assertExists()
   }

   @Test
   fun whenGoogleMapButtonIsClicked_listenerIsCalled(): Unit = with(composeTestRule) {
      var clickedUrl = ""

      setContent {
         DetailScreen(
            state = Result.Success(sampleCountry("aaa")),
            mapButtonClicked = { url -> clickedUrl = url },
            onBack = { }
         )
      }

      onNodeWithText(getStringResource(R.string.google_maps)).performClick()

      assert(clickedUrl.isNotBlank())
   }

   @Test
   fun whenOpenMapButtonIsClicked_listenerIsCalled(): Unit = with(composeTestRule) {
      var clickedUrl = ""

      setContent {
         DetailScreen(
            state = Result.Success(sampleCountry("aaa")),
            mapButtonClicked = { url -> clickedUrl = url },
            onBack = { }
         )
      }

      onNodeWithText(getStringResource(R.string.openstreet_maps)).performClick()

      assert(clickedUrl.isNotBlank())
   }

   @Test
   fun whenBackButtonIsClicked_listenerIsCalled(): Unit = with(composeTestRule) {
      var clicked = false

      setContent {
         DetailScreen(
            state = Result.Success(sampleCountry("aaa")),
            mapButtonClicked = { url -> },
            onBack = { clicked = true }
         )
      }

      onNodeWithTag(BACK_BUTTON_TEST_TAG).performClick()

      assert(clicked)
   }
}

private fun getStringResource(@StringRes id: Int): String {
   val context = InstrumentationRegistry.getInstrumentation().targetContext
   return context.getString(id)
}