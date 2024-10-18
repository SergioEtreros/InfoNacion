package com.minato.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.minato.common.theme.blueLinearBrushButton

const val BACK_BUTTON_TEST_TAG = "BackButton"

@Composable
fun BackButton(onBack: () -> Unit) {
   IconButton(
      modifier = Modifier
         .padding(start = 20.dp)
         .advancedShadow(
            color = Color(0x802B3445),
            cornersRadius = 10.dp,
            offsetX = (-3).dp,
            offsetY = (-3).dp,
            shadowBlurRadius = 5.dp,
         )
         .advancedShadow(
            color = Color(0xFF10141C),
            cornersRadius = 10.dp,
            offsetX = 3.dp,
            offsetY = 3.dp,
            shadowBlurRadius = 5.dp,
         )
         .testTag(BACK_BUTTON_TEST_TAG)
         .background(
            blueLinearBrushButton, RoundedCornerShape(size = 10.dp)
         ),
      onClick = onBack
   ) {
      Icon(
         imageVector = Icons.AutoMirrored.Default.ArrowBack,
         contentDescription = stringResource(id = R.string.back)
      )
   }
}