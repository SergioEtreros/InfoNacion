package com.minato.common.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.minato.common.px

val PrimaryLight = Color(0xFFC3F4DB)
val PrimaryAltLight = Color(0xFFDEF9E6)
val SecondaryLight = Color(0xFFE5E1FA)
val SecondaryAltLight = Color(0xFFF7F2FC)
val TertiaryLight = Color(0xFFFFF2D1)
val TertiaryAltLight = Color(0xFFFFFCF0)

val BackGroundLight = Color(0xFF242C3B)

val blueLinear1 = Color(0xFF34C8E8)
val blueLinear2 = Color(0xFF4E4AF2)

val greyLinear1 = Color(0xFF353F54)
val greyLinear2 = Color(0xFF222834)

val strokeBrush = Brush.verticalGradient(listOf(Color(0x10FFFFFF), Color(0x00000000)))

val PrimaryDark = Color(0xFF419B6C)
val PrimaryAltDark = Color(0xFF45A562)
val SecondaryDark = Color(0xFF5144AA)
val SecondaryAltDark = Color(0xFF7453A4)
val TertiaryDark = Color(0xFFBA902E)
val TertiaryAltDark = Color(0xFFC2A332)

val blueLinearBrushShape = Brush.linearGradient(
   colors = listOf(blueLinear1, blueLinear2),
   start = Offset(-100.dp.value.px, 250.dp.value.px),
   end = Offset(400.dp.value.px, 500.dp.value.px)
)

val blueLinearBrushButton = Brush.linearGradient(
   colors = listOf(blueLinear1, blueLinear2),
)
val greyLinearBrush = Brush.linearGradient(listOf(greyLinear1, greyLinear2))