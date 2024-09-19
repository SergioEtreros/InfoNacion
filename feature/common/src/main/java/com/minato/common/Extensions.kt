package com.minato.common

import android.content.res.Resources
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import kotlin.math.atan

class ObliqueCustomShape(
   private val offSet: Dp = 10.dp,
   private val cornerRadius: Dp = 5.dp
) : Shape {

   override fun createOutline(
      size: Size,
      layoutDirection: LayoutDirection,
      density: Density
   ): Outline {
      val path = crateObliquePath(
         width = size.width,
         height = size.height,
         offSet = offSet,
         cornerRadius = cornerRadius
      )
      return Outline.Generic(path)
   }
}

fun crateObliquePath(
   width: Float,
   height: Float,
   offSet: Dp,
   cornerRadius: Dp
): Path {

   val offset = offSet.value.px
   val corner = cornerRadius.value.px

   val degreeOffset = atan(width / offset) + 20
   val shortSweepAngle = 90f - degreeOffset
   val longSweepAngle = 90f + degreeOffset
   return Path().apply {
      moveTo(0f, offset + corner)
      arcTo(
         rect = Rect(
            left = 0f,
            top = offset,
            right = corner,
            bottom = offset + corner
         ),
         startAngleDegrees = 180f,
         sweepAngleDegrees = shortSweepAngle,
         forceMoveTo = true
      )

      lineTo(width - corner / 2, 0f)

      arcTo(
         rect = Rect(
            left = width - corner,
            top = 0f,
            right = width,
            bottom = corner
         ),
         startAngleDegrees = 270f - degreeOffset,
         sweepAngleDegrees = longSweepAngle,
         forceMoveTo = false
      )

      lineTo(width, height - corner - offset)

      arcTo(
         rect = Rect(
            left = width - corner,
            top = height - corner - offset,
            right = width,
            bottom = height - offset
         ),
         startAngleDegrees = 0f,
         sweepAngleDegrees = shortSweepAngle,
         forceMoveTo = false
      )

      lineTo(corner / 2, height)

      arcTo(
         rect = Rect(
            left = 0f,
            top = height - corner,
            right = corner,
            bottom = height
         ),
         startAngleDegrees = 90f - degreeOffset,
         sweepAngleDegrees = longSweepAngle,
         forceMoveTo = false
      )

      close()
   }
}

val Float.px: Float
   get() = (this * Resources.getSystem().displayMetrics.density)