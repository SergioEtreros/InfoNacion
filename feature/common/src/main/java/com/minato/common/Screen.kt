package com.minato.common

import androidx.compose.runtime.Composable
import com.minato.common.theme.InfoNacionTheme

@Composable
fun Screen(content: @Composable () -> Unit) {
   InfoNacionTheme {
      content()
   }
}