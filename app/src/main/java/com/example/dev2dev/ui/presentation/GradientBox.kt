package com.example.dev2dev.ui.presentation

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Pink200 = Color(0xFF570721)
val Pink400 = Color(0xFFE4779C)


@Composable
fun GradientBox(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
){
        Box(
            modifier = modifier.background(brush = Brush.linearGradient(
                listOf(Pink200 , Pink400)
            ))
        ){
            content()
        }
}