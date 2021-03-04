package com.johnny.learn.ui.layout

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.johnny.learn.R
import com.johnny.learn.ui.theme.LearnComposeScaffold
import com.johnny.learn.ui.theme.LearnComposeTheme
import com.johnny.learn.ui.theme.background800
import com.johnny.learn.ui.theme.shimmerHighLight
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

/**
 *
 * 布局展示
 *
 */
class ConstraintActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Guideline
//        引导线，可以从特定的位置（某一方向上的偏移量或者某一方向上的比例）创建一条实际并不可见的参考线。总共有如下几种方式：
//
//        createGuidelineFromStart(offset: Dp)
//        createGuidelineFromAbsoluteLeft(offset: Dp)
//        createGuidelineFromStart(fraction: Float)
//        createGuidelineFromAbsoluteLeft(fraction: Float)
//        createGuidelineFromEnd(offset: Dp)
//        createGuidelineFromAbsoluteRight(offset: Dp)
//        createGuidelineFromEnd(fraction: Float)
//        createGuidelineFromAbsoluteRight(fraction: Float)
//        createGuidelineFromTop(offset: Dp)
//        createGuidelineFromTop(fraction: Float)
//        createGuidelineFromBottom(offset: Dp)
//        createGuidelineFromBottom(fraction: Float)
//        ————————————————
//        Barrier 屏障
//        createStartBarrier()
//        createAbsoluteLeftBarrier()
//        createTopBarrier()
//        createEndBarrier()
//        createAbsoluteRightBarrier()
//        createBottomBarrier()
//        Chain 链
//        createHorizontalChain()
//        createVerticalChain()
        setContent {
            LearnComposeScaffold {
//约束
                ConstraintLayout(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val guideline = createGuidelineFromStart(0.2f)
                    val (box1, box2, box3,box4) = createRefs()

                    Box(
                        modifier = Modifier
                            .size(100.dp, 100.dp)
                            .background(color = Color.Yellow)
                            .constrainAs(box1) {
                                end.linkTo(guideline)
                            }
                    )

                    Box(
                        modifier = Modifier
                            .size(100.dp, 100.dp)
                            .background(color = Color.Red)
                            .constrainAs(box2) {
                                start.linkTo(guideline)
                            }
                    )
                    Box(
                        modifier = Modifier
                            .constrainAs(box3) {
                                top.linkTo(box1.bottom)
                            }
                    ) {

                        ConstraintLayoutIdDemo()
                    }
                    Box(
                        modifier = Modifier
                            .constrainAs(box4) {
                                top.linkTo(box3.bottom)
                            }
                    ) {

                        ConstraintLayoutChainDemo()
                    }
                }
            }
        }
    }
}

/**
 * Barrier 屏障
 */
@Composable
fun ConstraintLayoutIdDemo() {
    ConstraintLayout(
        ConstraintSet {
            val box1 = createRefFor("box1")
            val box2 = createRefFor("box2")
            val box3 = createRefFor("box3")

            constrain(box1) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }

            constrain(box2) {
                top.linkTo(box1.bottom)
                start.linkTo(parent.start)
            }

            val barrier = createEndBarrier(box1, box2)

            constrain(box3) {
                start.linkTo(barrier)
                top.linkTo(box1.top)
                bottom.linkTo(box2.bottom)
            }
        }
    ) {
        Box(
            modifier = Modifier
                .layoutId("box1")
                .background(color = Color.Green)
                .width(100.dp)
                .height(100.dp)
        )
        Box(
            modifier = Modifier
                .layoutId("box2")
                .background(color = Color.Yellow)
                .width(150.dp)
                .height(100.dp)
        )
        Box(
            modifier = Modifier
                .layoutId("box3")
                .background(color = Color.Gray)
                .width(200.dp)
                .height(100.dp)
        )
    }
}

/**
 * 、Chain
链
 */
@Composable
fun ConstraintLayoutChainDemo() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (box1, box2, box3) = createRefs()
        createHorizontalChain(box1, box2, box3)

        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Red)
            .constrainAs(box1) {})
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Yellow)
            .constrainAs(box2) {})
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Blue)
            .constrainAs(box3) {})
    }
}
