package com.johnny.learn.ui.text

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.johnny.learn.data.exampleMainUiState
import com.johnny.learn.ui.main.MainContent
import com.johnny.learn.ui.theme.LearnComposeTheme

/**
 *
 * Text 展示
 *
 */
class TextViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                TextViewContent( )
            }
        }
    }
}
