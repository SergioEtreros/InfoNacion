package com.minato.common

import android.content.res.Resources
import android.graphics.BlurMaskFilter
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
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

fun Modifier.advancedShadow(
   color: Color = Color.Black,
   alpha: Float = 1f,
   cornersRadius: Dp = 0.dp,
   shadowBlurRadius: Dp = 0.dp,
   offsetY: Dp = 0.dp,
   offsetX: Dp = 0.dp
) = drawBehind {

   val shadowColor = color.copy(alpha = alpha).toArgb()
   val transparentColor = color.copy(alpha = 0f).toArgb()

   drawIntoCanvas {
      val paint = Paint()
      val frameworkPaint = paint.asFrameworkPaint()
      frameworkPaint.color = transparentColor
      frameworkPaint.setShadowLayer(
         shadowBlurRadius.toPx(),
         offsetX.toPx(),
         offsetY.toPx(),
         shadowColor
      )

      it.drawRoundRect(
         0f,
         0f,
         this.size.width,
         this.size.height,
         cornersRadius.toPx(),
         cornersRadius.toPx(),
         paint
      )
   }
}

fun Modifier.innerShadow(
   shape: Shape,
   color: Color = Color.Black,
   blur: Dp = 4.dp,
   offsetY: Dp = 2.dp,
   offsetX: Dp = 2.dp,
   spread: Dp = 0.dp
) = this.drawWithContent {

   drawContent()

   drawIntoCanvas { canvas ->

      val shadowSize = Size(size.width + spread.toPx(), size.height + spread.toPx())
      val shadowOutline = shape.createOutline(shadowSize, layoutDirection, this)

      val paint = Paint()
      paint.color = color

      canvas.saveLayer(size.toRect(), paint)
      canvas.drawOutline(shadowOutline, paint)

      paint.asFrameworkPaint().apply {
         xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
         if (blur.toPx() > 0) {
            maskFilter = BlurMaskFilter(blur.toPx(), BlurMaskFilter.Blur.NORMAL)
         }
      }

      paint.color = Color.Black

      canvas.translate(offsetX.toPx(), offsetY.toPx())
      canvas.drawOutline(shadowOutline, paint)
      canvas.restore()
   }
}