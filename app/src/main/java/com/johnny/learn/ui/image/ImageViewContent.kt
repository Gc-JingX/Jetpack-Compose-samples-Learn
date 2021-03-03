package com.johnny.learn.ui.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.johnny.learn.R
import com.johnny.learn.ui.theme.LearnComposeTheme

@Composable
fun ImageViewContent() {
    /**
     * 默认会滚动
     *
     * 旧版本用这俩个 ScrollableRow 和 ScrollableColumn 新版本api已经被LazyColumn和 LazyRow取代
     */
    LazyColumn(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth() ) {
        item {
            imageComposable()
        }
//        item {
//            ZoomableComposable(
//            )
//        }


    }

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
fun ZoomableComposable() {

    var scale by remember { mutableStateOf(1f) }

    var rotation by remember { mutableStateOf(0f) }
    var offset by remember { mutableStateOf(Offset.Zero) }
    val state = rememberTransformableState { zoomChange, offsetChange, rotationChange ->
        scale *= zoomChange
        rotation += rotationChange
        offset += offsetChange
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {

        Image(
            painter = painterResource(id = R.drawable.test),
            contentDescription = null, // decorative
                    modifier = Modifier
                        .fillMaxSize()
                        .transformable(state = state)
                        .graphicsLayer(
                            scaleX = scale,
                            scaleY = scale,
//                            rotationZ = rotation,
                            translationX = offset.x,
                            translationY = offset.y
                        ),)
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