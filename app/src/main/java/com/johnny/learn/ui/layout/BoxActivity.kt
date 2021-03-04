package com.johnny.learn.ui.layout

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.johnny.learn.ui.theme.LearnComposeScaffold

/**
 *
 * 布局展示
 *
 */
class BoxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeScaffold {
                LearnComposeScaffold {
                    /**
                     * 可以理解为FrameLayout
                     */
                    Box(
                        modifier = Modifier
                            .width(360.dp)
                            .height(200.dp)
                            .background(Color.Red),
                        contentAlignment = Alignment.Center,
                    ) {
                        //子Box1
                        Box(
                            modifier = Modifier
                                .fillMaxSize(0.5f)
                                .background(color = Color.Black)
                        )

                        //子Box2
                        Box(
                            modifier = Modifier
                                .fillMaxSize(0.2f)
                                .background(color = Color.White)
                        )
                        Text(text = "我是第1个View",style = TextStyle(color = Color.Black))
                        Text(text = "我是第2个View",style = TextStyle(color = Color.Green,fontSize = 28.sp))
                    }
                }
            }
        }
    }
}
