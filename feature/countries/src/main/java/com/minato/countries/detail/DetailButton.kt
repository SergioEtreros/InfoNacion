package com.minato.countries.detail

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.minato.common.advancedShadow
import com.minato.common.innerShadow
import com.minato.common.theme.greyBackground
import com.minato.common.theme.sombraExteriorBoton1
import com.minato.common.theme.sombraExteriorBoton2
import com.minato.common.theme.sombraInteriorBoton1
import com.minato.common.theme.sombraInteriorBoton2

@Composable
fun DetailButton(
   onClick: () -> Unit,
   modifier: Modifier = Modifier,
   active: Boolean = false,
   content: @Composable (RowScope.() -> Unit)
) {

   val shape = RoundedCornerShape(10.dp)
   val shadowModifier = if (active) {
      modifier
         .advancedShadow(
            color = sombraExteriorBoton1,
            offsetX = (-4).dp,
            offsetY = (-4).dp,
            shadowBlurRadius = 10.dp,
         )
         .advancedShadow(
            color = sombraExteriorBoton2,
            offsetX = 4.dp,
            offsetY = 4.dp,
            shadowBlurRadius = 10.dp,
         )
   } else {
      modifier
         .innerShadow(
            shape = shape,
            color = sombraInteriorBoton1,
            blur = 8.dp,
            offsetX = (-4).dp,
            offsetY = (-4).dp,
         )
         .innerShadow(
            shape = shape,
            color = sombraInteriorBoton2,
            blur = 8.dp,
            offsetX = 4.dp,
            offsetY = 4.dp,
         )
   }

   Button(
      onClick = onClick,
      shape = shape,
      colors = ButtonDefaults.buttonColors()
         .copy(containerColor = greyBackground),
      modifier = shadowModifier
   ) {
      content()
   }
}