package com.johnny.learn.ui.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp

@Composable
fun BottonViewContent() {
    /**
     * 默认会滚动
     *
     * 旧版本用这俩个 ScrollableRow 和 ScrollableColumn 新版本api已经被LazyColumn和 LazyRow取代
     */
    LazyColumn {
        item {
            CustomStyledBtn(

            )
        }
        item {
            CustomStyledBtn(

                shape = RoundedCornerShape(10.dp),
            )
        }
        item {
            CustomStyledBtn(


                border = BorderStroke(width = 2.dp, brush = SolidColor(Color.Black))
            )
        }
        item {
            CustomStyledBtn(

                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(width = 5.dp, brush = SolidColor(Color.Black))
            )
        }

    }

}

@Composable
fun CustomStyledBtn(border: BorderStroke? = null, shape: Shape? = null) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {

            },
    ) {
        var useShape = shape
        if (useShape == null) {
            useShape = MaterialTheme.shapes.small
        }
        /**
         *
         *
         * 哈哈哈，看到这里没有，是不是觉得button有点多余 其实不是 ，你可以理解为他就是一个自定义的样式控件，给控件做装饰或者业务调用
         */
        Button(
            onClick = {},
            modifier = Modifier.padding(16.dp),
            elevation = ButtonDefaults.elevation(5.dp),
            border = border,
            shape = useShape
        ) {
            Text(text = "按钮", modifier = Modifier.padding(16.dp))
        }
    }

}