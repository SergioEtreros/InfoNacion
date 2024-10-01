package com.minato.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.minato.common.theme.blueLinearBrushButton

@Composable
fun MapLinkButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
   Box(
      modifier = modifier
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
         .background(
            brush = blueLinearBrushButton,
            shape = RoundedCornerShape(size = 10.dp)
         )
         .clickable { onClick() }
         .padding(8.dp)
   ) {
      Text(
         modifier = Modifier.align(Alignment.Center),
         text = text,
         color = Color.White
      )
   }
}

@Preview
@Composable
private fun MapLinkButtonPreview() {
   MapLinkButton(text = "Preview", modifier = Modifier.fillMaxWidth(), onClick = { })
}