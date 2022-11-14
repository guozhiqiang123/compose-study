package com.gzq.wanandroid.features.home.project.pages

import android.media.Image
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.navigation.animation.composable
import com.gzq.wanandroid.core.preview.DevicePreviews
import com.gzq.wanandroid.core.preview.ThemePreviews
import com.gzq.wanandroid.router.Router
import com.gzq.wanandroid.ui.theme.AndroidTemplateTheme
import com.gzq.wanandroid.widget.MyTopAppBar

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.coilImagePage(navController: NavHostController) {
    composable(Router.CoilImagePage.route) {
        CoilImagePage() {
            navController.popBackStack()
        }
    }
}
@ThemePreviews
@DevicePreviews
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoilImagePage(clickBack: (() -> Unit)? = null) {
    AndroidTemplateTheme {
        Scaffold(topBar = {
            MyTopAppBar(titleStr = "实验Coil加载图片功能", clickBack = clickBack ?: {})
        }) { paddingValue ->
            Column(Modifier.padding(paddingValue)) {

                Text(text = "简单加载", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(12.dp))

                AsyncImage(model = imageUrl, contentDescription = null)


                Divider(Modifier.padding(vertical = 8.dp))

                Text(text = "监听状态", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(12.dp))

                val painter = rememberAsyncImagePainter(imageUrl)

                Box {
                    Image(painter = painter, contentDescription = null, Modifier.size(200.dp))
                    when (painter.state) {
                        is AsyncImagePainter.State.Loading -> {
                            // 显示一个加载中的进度条
                            CircularProgressIndicator(Modifier.align(Alignment.Center))
                        }

                        is AsyncImagePainter.State.Error -> {
                            // 如果发生了什么错误，你可以在这里写
                            Text(text = "发生错误",
//                                color = TextColorRed
                            )
                        }

                        else -> {

                        }
                    }
                }
            }
        }
    }
}