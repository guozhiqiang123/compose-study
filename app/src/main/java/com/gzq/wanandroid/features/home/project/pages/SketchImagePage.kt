package com.gzq.wanandroid.features.home.project.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.github.panpf.sketch.compose.AsyncImage
import com.github.panpf.sketch.request.DisplayRequest
import com.github.panpf.sketch.request.svgBackgroundColor
import com.github.panpf.sketch.request.svgCss
import com.gzq.wanandroid.core.preview.DevicePreviews
import com.gzq.wanandroid.core.preview.ThemePreviews
import com.gzq.wanandroid.router.Router
import com.gzq.wanandroid.ui.theme.AndroidTemplateTheme
import com.gzq.wanandroid.widget.MyTopAppBar

fun NavGraphBuilder.sketchImagePage(navController: NavHostController) {
    composable(Router.SketchImagePage.route) {
        SketchImagePage() {
            navController.popBackStack()
        }
    }
}

@ThemePreviews
@DevicePreviews
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SketchImagePage(clickBack: (() -> Unit)? = null) {
    AndroidTemplateTheme {
        Scaffold(topBar = {
            MyTopAppBar(
                clickBack = clickBack ?: {},
                titleStr = "实验Sketch加载图片"
            )
        }) { paddingValues ->
            Column(
                Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
                    .verticalScroll(state = rememberScrollState())
            ) {
                Text(text = "简单加载", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(12.dp))
                AsyncImage(
                    imageUri = imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                ) {
                    crossfade()
                }

                Text(text = "加载SVG", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(12.dp))
                AsyncImage(
                    imageUri = "asset://svg/play.svg",
                    contentDescription = null,
                    modifier = Modifier.size(300.dp)//必须设置大小，否则不显示
                ) {
                    svgBackgroundColor(Color.Green.toArgb())
                }
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 750)
@Composable
fun PreviewSketchImagePage() {
    SketchImagePage()
}