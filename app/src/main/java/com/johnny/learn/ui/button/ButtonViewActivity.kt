package com.johnny.learn.ui.button

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.johnny.learn.ui.theme.LearnComposeTheme

/**
 *
 * Text 展示
 *
 */
class ButtonViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                BottonViewContent( )
            }
        }
    }
}
