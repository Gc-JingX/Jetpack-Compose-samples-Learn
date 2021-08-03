package com.johnny.learn.ui.dataview

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.johnny.learn.ui.theme.LearnComposeTheme

/**
 *
 * Text 展示
 *
 */
class DataView1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                DataView1Content( )
            }
        }
    }
}
