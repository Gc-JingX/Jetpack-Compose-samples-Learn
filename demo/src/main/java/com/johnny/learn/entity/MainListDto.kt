package com.johnny.learn.entity

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Immutable

@Immutable
data class MainListDto(

    val index: Int,
    val showText: String,
    val cls:  Class<*>?,
)