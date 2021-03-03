package com.johnny.learn.ui.image

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.johnny.learn.R
import com.johnny.learn.ui.theme.LearnComposeTheme

/**
 *
 * Text 展示
 *
 */
class ImageViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                ImageViewContent( )
            }
        }
    }
}
