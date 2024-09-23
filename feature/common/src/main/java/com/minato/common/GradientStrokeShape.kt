package com.minato.common

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.minato.common.theme.PrimaryDark
import com.minato.common.theme.SecondaryDark
import com.minato.common.theme.TertiaryDark

@Composable
fun GradientStrokeShape(
   modifier: Modifier = Modifier,
   strokeWidth: Dp = 1.dp,
   colors: List<Color> = listOf(
      PrimaryDark,
      SecondaryDark,
      TertiaryDark,
      TertiaryDark,
      SecondaryDark,
      PrimaryDark,
   ),
   shape: Shape,
   onCardClick: () -> Unit = {},
   content: @Composable () -> Unit
) {

   val brush = Brush.sweepGradient(colors)
   val infiniteTransition = rememberInfiniteTransition(label = "")
   val angle by
   infiniteTransition.animateFloat(
      initialValue = 0f,
      targetValue = 360f,
      animationSpec =
      infiniteRepeatable(
         animation = tween(1500, easing = LinearEasing),
         repeatMode = RepeatMode.Restart
      ),
      label = ""
   )

   Surface(modifier = modifier, shape = shape) {
      Surface(
         modifier =
         Modifier
            .clickable { onCardClick() }
            .clipToBounds()
            .fillMaxWidth()
            .padding(strokeWidth)
            .drawWithContent {
               rotate(angle) {
                  drawCircle(
                     brush = brush,
                     radius = size.width,
                     blendMode = BlendMode.SrcIn,
                  )
               }
               drawContent()
            },
         color = MaterialTheme.colorScheme.background,
         shape = shape
      ) {
         content()
      }
   }
}