package com.johnny.learn.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.johnny.learn.entity.MainListDto

@Composable
fun MainContent(mainList: List<MainListDto>) {

    Column(
        modifier = Modifier.fillMaxWidth(),

        ) {
        mainList.forEachIndexed { index, data ->

            CustomStyledText(data.showText, index)
        }
    }
}

@Composable
fun CustomStyledText(displayText: String, index: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {


            },
    ) {
        Text(
            text = displayText,
            modifier = Modifier.padding(16.dp),
            style = TextStyle.Default,
            overflow = TextOverflow.Ellipsis,
            maxLines = Int.MAX_VALUE
        )
        Divider(color = Color.Gray)
    }

}