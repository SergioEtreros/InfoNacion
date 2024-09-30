package com.minato.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.minato.common.theme.blueLinearBrushButton

@Composable
fun LocateButton(onLocationClick: () -> Unit) {
   IconButton(
      modifier = Modifier
         .padding(
            end = 12.dp
         )
         .background(
            blueLinearBrushButton, RoundedCornerShape(size = 10.dp)
         ),
      onClick = onLocationClick
   ) {
      Icon(
         imageVector = Icons.Default.LocationOn,
         contentDescription = stringResource(id = R.string.current_location),
         tint = MaterialTheme.colorScheme.onSurface
      )
   }
}