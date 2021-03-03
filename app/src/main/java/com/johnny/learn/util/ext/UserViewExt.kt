package com.johnny.learn.util.ext

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleComponent(title: String) {
    Text(
        title, style = TextStyle(
            fontFamily = FontFamily.Monospace, fontWeight = FontWeight.W900,
            fontSize = 14.sp, color = Color.Black
        ), modifier = Modifier.padding(16.dp).fillMaxWidth()
    )
}