package com.johnny.learn.ui.image

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.johnny.learn.R
import com.johnny.learn.ui.theme.LearnComposeTheme
import com.skydoves.landscapist.coil.CoilImage
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import coil.ImageLoader
import coil.request.ImageRequest
import com.johnny.learn.ui.image.view.StaggeredVerticalGrid
import com.johnny.learn.ui.theme.background800
import com.johnny.learn.ui.theme.shimmerHighLight
import com.skydoves.landscapist.ShimmerParams

@Composable
fun ImageViewContent() {
    /**
     * 默认会滚动
     *
     * 旧版本用这俩个 ScrollableRow 和 ScrollableColumn 新版本api已经被LazyColumn和 LazyRow取代
     */
    Column(
    ) {
        StaggeredVerticalGrid(
            maxColumnWidth = 220.dp,
            modifier = Modifier.padding(4.dp)
        ) {
            PicPoster( )
            PicPoster( )
            PicPoster( )
            PicPoster( )
        }
    }
//    LazyColumn(modifier = Modifier
//        .fillMaxHeight()
//        .fillMaxWidth() ) {
//        item {
//            imageComposable()
//        }
//        item {
//            StaggeredVerticalGrid(
//                maxColumnWidth = 220.dp,
//                modifier = Modifier.padding(4.dp)
//            ) {
//                PicPoster( )
//                PicPoster( )
//                PicPoster( )
//                PicPoster( )
//            }
//        }
//
//
//    }

}
@Composable
fun imageComposable() {

        Image(
            painter = painterResource(id = R.drawable.test),
            contentDescription = null, // decorative
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(20.dp)
                .height(100.dp)
                .fillMaxWidth()
        )

}

@Composable
fun PicPoster(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .padding(6.dp)
            .clickable(
                onClick = { }
            ),
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        //约束
        ConstraintLayout {

            val (image, title, content) = createRefs()

//            CoilImage(
//                imageModel = poster.poster,
//                modifier = Modifier.constrainAs(image) {
//                    centerHorizontallyTo(parent)
//                    top.linkTo(parent.top)
//                }.aspectRatio(0.8f),
//                // shows a progress indicator when loading an image.
//                loading = {
//                    ConstraintLayout(
//                        modifier = Modifier.fillMaxSize()
//                    ) {
//                        val indicator = createRef()
//                        CircularProgressIndicator(
//                            modifier = Modifier.constrainAs(indicator) {
//                                top.linkTo(parent.top)
//                                bottom.linkTo(parent.bottom)
//                                start.linkTo(parent.start)
//                                end.linkTo(parent.end)
//                            }
//                        )
//                    }
//                },
//                // shows an error text message when request failed.
//                failure = {
//                    Text(text = "image request failed.")
//                })
            CoilImage(
                imageModel = R.drawable.test,
                modifier = Modifier
                    .constrainAs(image) {
                        centerHorizontallyTo(parent)
                        top.linkTo(parent.top)
                    },
//                    .aspectRatio(0.8f),
//                contentScale = ContentScale.FillWidth,
                circularRevealedEnabled = true,
                shimmerParams = ShimmerParams(
                    baseColor = background800,
                    highlightColor = shimmerHighLight
                )
            )
            Text(
                text = "哈哈哈",
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .constrainAs(title) {
                        centerHorizontallyTo(parent)
                        top.linkTo(image.bottom)
                    }
                    .padding(8.dp)
            )
            Text(
                text = "2021年3月4日14:43:00",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .constrainAs(content) {
                        centerHorizontallyTo(parent)
                        top.linkTo(title.bottom)
                    }
                    .padding(horizontal = 8.dp)
                    .padding(bottom = 12.dp)
            )
        }
    }
}


@Preview
@Composable
fun TestImagePreview() {
    LearnComposeTheme {
        ImageViewContent( )
    }
}

@Preview
@Composable
fun TestImagePreviewDark() {
    LearnComposeTheme(darkTheme = true) {
        ImageViewContent( )
    }
}