package com.minato.common.theme

import androidx.compose.foundation.shape.GenericShape
import androidx.compose.ui.unit.dp
import com.minato.common.ObliqueCustomShape
import com.minato.common.px

val obliquedShape = ObliqueCustomShape(offSet = 30.dp, cornerRadius = 20.dp)

val trapezoidShape = GenericShape { size, _ ->
   moveTo(350.dp.value.px, 0f)
   lineTo(size.width, 0f)
   lineTo(size.width, size.height)
   lineTo(00f, size.height)
}



