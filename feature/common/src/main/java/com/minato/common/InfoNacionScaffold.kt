package com.minato.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun <T> InfoNacionScaffold(
   state: Result<T>,
   modifier: Modifier = Modifier,
   topBar: @Composable () -> Unit = {},
   bottomBar: @Composable () -> Unit = {},
   snackbarHost: @Composable () -> Unit = {},
   floatingActionButton: @Composable () -> Unit = {},
   floatingActionButtonPosition: FabPosition = FabPosition.End,
   containerColor: Color = MaterialTheme.colorScheme.background,
   contentColor: Color = contentColorFor(containerColor),
   contentWindowInsets: WindowInsets = WindowInsets.statusBars,
   content: @Composable (PaddingValues, T) -> Unit
) {
   Scaffold(
      modifier = modifier,
      containerColor = containerColor,
      contentColor = contentColor,
      contentWindowInsets = contentWindowInsets,
      topBar = topBar,
      bottomBar = bottomBar,
      snackbarHost = snackbarHost,
      floatingActionButton = floatingActionButton,
      floatingActionButtonPosition = floatingActionButtonPosition
   ) { paddingValues ->
      when (state) {
         is Result.Loading -> LoadingIndicator(paddingValues)
         is Result.Error -> Text(text = state.throwable.message.orEmpty())
         is Result.Success -> content(paddingValues, state.data)
      }
   }
}