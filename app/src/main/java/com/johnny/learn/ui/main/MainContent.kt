package com.johnny.learn.ui.main

import android.content.Context
import android.content.Intent
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
import com.johnny.learn.ui.text.TextViewActivity

@Composable
fun MainContent(
    mainList: List<MainListDto>,
    context: Context
) {
//    Modifier 的参数
//    clickable() 使可组合项响应用户输入。
//    padding() 在元素周围留出空间。
//    fillMaxWidth() 使可组合项填充其父项给它的最大宽度。
//    preferredSize() 指定元素的首选宽度和高度。
    Column(
        modifier = Modifier.fillMaxWidth(),

        ) {
        mainList.forEachIndexed { index, data ->

            CustomStyledText(data.showText, index, context)
        }
    }
}

@Composable
fun CustomStyledText(
    displayText: String, index: Int,
    context: Context
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                when (index) {
                    0 -> {
                        context.startActivity(Intent(context, TextViewActivity::class.java))
                    }
                }

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