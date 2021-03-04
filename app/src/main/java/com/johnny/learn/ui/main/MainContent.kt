package com.johnny.learn.ui.main

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.johnny.learn.R
import com.johnny.learn.entity.MainListDto
import com.johnny.learn.ui.button.ButtonViewActivity
import com.johnny.learn.ui.image.ImageViewActivity
import com.johnny.learn.ui.dataview.DataView1Activity
import com.johnny.learn.ui.text.TextViewActivity
import com.johnny.learn.ui.textfield.TextFieldActivity
import com.johnny.learn.ui.theme.background800
import com.johnny.learn.ui.theme.shimmerHighLight
import com.johnny.learn.util.view.UserBar
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

//函数带有 @Composable 注释。
// 所有可组合函数都必须带有此注释；
// 此注释可告知 Compose 编译器：
// 此函数旨在将数据转换为界面


var mContext: Context? = null

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainContent(
    modifier: Modifier = Modifier,
    topPadding: Dp = 0.dp,
    mainList: List<MainListDto>,
    context: Context
) {
    mContext = context
//    Modifier 的参数
//    clickable() 使可组合项响应用户输入。
//    padding() 在元素周围留出空间。
//    fillMaxWidth() 使可组合项填充其父项给它的最大宽度。
//    preferredSize() 指定元素的首选宽度和高度。


    /**
     * 这是一个神奇的抽屉控件
     */
    val imageModifier = Modifier
        .heightIn(min = 180.dp)
        .fillMaxWidth()
        .clip(shape = MaterialTheme.shapes.medium)
    BackdropScaffold(
        modifier = modifier,
        scaffoldState = rememberBackdropScaffoldState(BackdropValue.Revealed),
        frontLayerScrimColor = Color.Transparent,
        appBar = {
            TopView(modifier = modifier)
//            Image(
//                painter = painterResource(R.drawable.test),
//                contentDescription = null, // decorative
//                modifier = imageModifier,
//                contentScale = ContentScale.Crop
//            )
        },
        backLayerContent = {
            Box(
                modifier = modifier
                    .fillMaxWidth()
//                .padding(6.dp)
                    .clickable(
                        onClick = { }
                    ),
            ) {
                Image(
                    painter = painterResource(R.drawable.test),
                    contentDescription = null, // decorative
                    modifier = imageModifier,
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Jetpack Compose",
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(fontSize = 32.sp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = Int.MAX_VALUE
                )
            }
        },
        frontLayerContent = {
            Column(
                modifier = modifier,

                ) {
                Spacer(Modifier.padding(top = topPadding))
                mainList.forEachIndexed { index, data ->

                    CustomStyledText(modifier, data, index)
                }
            }
        }
    )


}

@Composable
fun TopView(
    modifier: Modifier = Modifier,
) {
    Row(modifier) {
        // Separate Row as the children shouldn't have the padding
        Row(Modifier.padding(top = 0.dp)) {
//            Spacer(Modifier.width(8.dp))
//            Image(
//                painter = painterResource(id = R.drawable.test),
//                contentDescription = null
//            )
        }
    }
}

@Composable
fun CustomStyledText(
    modifier: Modifier = Modifier,
    data: MainListDto, index: Int
) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .clickable {
//                /**
//                 * 点击操作
//                 */
//                toDoView(index)
//
//            },
//    ) {
//        Text(
//            text = displayText,
//            modifier = Modifier.padding(16.dp),
//            style = TextStyle.Default,
//            overflow = TextOverflow.Ellipsis,
//            maxLines = Int.MAX_VALUE
//        )
//        Divider(color = Color.Black)
//    }
    Surface(
        modifier = modifier
            .padding(6.dp)
            .fillMaxWidth()
            .clickable(

                onClick = {
                    mContext?.run {

                        startActivity(Intent(this, data.cls))
                    }
                }
            ),
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = data.showText,
            modifier = Modifier.padding(16.dp),
            style = TextStyle.Default,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            maxLines = Int.MAX_VALUE
        )
//        Divider(color = Color.Black)
    }

}
