package com.johnny.learn

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.johnny.learn.data.exampleMainUiState
import com.johnny.learn.ui.image.ImageViewContent
import com.johnny.learn.ui.main.MainContent
import com.johnny.learn.ui.main.TopScreen
import com.johnny.learn.ui.theme.LearnComposeScaffold
import com.johnny.learn.ui.theme.LearnComposeTheme

/**
 * 主页
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        WindowCompat.setDecorFitsSystemWindows(window, false)
        //这个就是整个布局的显示体 可以理解为root
        setContent {

            /**
             * 主体
             */
            LearnComposeScaffold {

                /**
                 * 加载自定义主体 view
                 */
                    MainContent( mainList=exampleMainUiState.datas, context=this@MainActivity)
            }
        }
    }
}

enum class SplashState { Shown, Completed }
