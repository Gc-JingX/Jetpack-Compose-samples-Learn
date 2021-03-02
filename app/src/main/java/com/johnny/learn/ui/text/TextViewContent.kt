package com.johnny.learn.ui.text

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.johnny.learn.entity.MainListDto

@Composable
fun TextViewContent() {
    /**
     * 默认会滚动
     */
    LazyColumn {
        item {
            CustomStyledText(
                "Test default text style"
            )
        }
        item {
            CustomStyledText(
                "Test blue in color",
                style = TextStyle(
                    color = Color.Blue
                )
            )
        }
        item {
            CustomStyledText(
                "Test a bigger font size",
                style = TextStyle(
                    fontSize = 30.sp
                )
            )
        }
        item {
            CustomStyledText(
                "Test bold",
                style = TextStyle(
                    fontWeight = FontWeight.W700
                )
            )
        }
        item {
            CustomStyledText(
                "Test italic",
                style = TextStyle(
                    fontStyle = FontStyle.Italic
                )
            )
        }
        item {
            CustomStyledText(
                "Test using a custom font family",
                style = TextStyle(
                    fontFamily = FontFamily.Cursive
                )
            )

        }
        item {
            CustomStyledText(
                "Test an underline",
                style = TextStyle(
                    textDecoration = TextDecoration.Underline
                )
            )

        }
        item {
            CustomStyledText(
                "Test a strikethrough line",
                style = TextStyle(
                    textDecoration = TextDecoration.LineThrough
                )
            )

        }
        item {
            CustomStyledText(
                "test ellipsis to the end ",
                maxLines = 1
            )

        }
        item {
            CustomStyledText(
                "Test a shadow",
                style = TextStyle(
                    shadow = Shadow(
                        color = Color.Black, blurRadius = 10f,
                        offset = Offset(2f, 2f)
                    )
                )
            )

        }
        item {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Test center aligned",
                    style = TextStyle(
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.padding(16.dp)
                )
            }

        }
    }

}

@Composable
fun CustomStyledText(displayText: String, style: TextStyle? = null, maxLines: Int? = null) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {

            },
    ) {

        Text(
            text = displayText,
            modifier = Modifier.padding(12.dp),
            style = style ?: TextStyle.Default,
            overflow = TextOverflow.Ellipsis,
            maxLines = maxLines ?: Int.MAX_VALUE
        )
    }

}