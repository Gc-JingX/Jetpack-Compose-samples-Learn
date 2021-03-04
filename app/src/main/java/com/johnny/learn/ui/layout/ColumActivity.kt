package com.johnny.learn.ui.layout

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import com.johnny.learn.ui.button.CustomStyledBtn
import com.johnny.learn.ui.theme.LearnComposeScaffold

/**
 *
 * 布局展示
 *
 */
class ColumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeScaffold {
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

                }
//                Column {
//                    CustomStyledBtn(
//
//                        shape = RoundedCornerShape(10.dp),
//                    )
//
//                }
            }
        }
    }
}
