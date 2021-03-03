package com.johnny.learn

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.johnny.learn.data.exampleMainUiState
import com.johnny.learn.ui.main.MainContent
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
            LearnComposeTheme {
                /**
                 * 加载自定义主体 view
                 */
                MainContent(exampleMainUiState.datas,this@MainActivity)
            }
        }
    }
}
