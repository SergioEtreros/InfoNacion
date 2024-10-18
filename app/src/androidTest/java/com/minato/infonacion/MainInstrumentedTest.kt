package com.minato.infonacion

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasScrollToIndexAction
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.rule.GrantPermissionRule
import com.minato.infonacion.data.MockWebServerRule
import com.minato.infonacion.data.fromJson
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import okhttp3.mockwebserver.MockResponse
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class MainInstrumentedTest {

   @get:Rule(order = 0)
   val hiltRule = HiltAndroidRule(this)

   @get:Rule(order = 1)
   val mockWebServerRule = MockWebServerRule()

   @get:Rule(order = 2)
   val locationPermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
      "android.permission.ACCESS_COARSE_LOCATION"
   )

   @get:Rule(order = 3)
   val androidComposeRule = createAndroidComposeRule<MainActivity>()

   @Before
   fun setUp() {
      mockWebServerRule.mockWebServer.enqueue(MockResponse().fromJson("countries.json"))
      hiltRule.inject()
   }

   @OptIn(ExperimentalTestApi::class)
   @Test
   fun click_a_country_goes_to_detail(): Unit = with(androidComposeRule) {
      waitUntilAtLeastOneExists(hasParent(hasScrollToIndexAction()))
      onAllNodes(hasParent(hasScrollToIndexAction()))[2].performClick()

      onNodeWithText("Algeria").assertIsDisplayed()
   }
}