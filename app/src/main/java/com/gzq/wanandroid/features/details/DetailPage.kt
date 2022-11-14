package com.gzq.wanandroid.features.details

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.BackHandler
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.gzq.wanandroid.R
import com.gzq.wanandroid.router.Router
import com.gzq.wanandroid.router.isHomePage
import com.gzq.wanandroid.ui.theme.AndroidTemplateTheme
import com.gzq.wanandroid.widget.CustomWebView
import com.gzq.wanandroid.widget.MyTopAppBar
import com.gzq.wanandroid.widget.WebViewEvent

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.detailPage(
    navController: NavHostController,
    showBottomNavigationBar: (Boolean) -> Unit
) {
    composable(Router.DetailPage.route) {
        DetailPage(
            url = it.arguments?.getString("url")
                ?: throw IllegalArgumentException("url不能为空")
        ) {
            showBottomNavigationBar(navController.previousBackStackEntry!!.isHomePage())
            navController.popBackStack()
        }
    }
}

@SuppressLint("SetJavaScriptEnabled")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailPage(url: String, clickBack: () -> Unit) {

    val ctx = LocalContext.current

    //将我们自己的返回点击代理给系统
    //否则点击物理返回按钮不会执行showBottomNavigation的逻辑
    BackHandler(onBack = clickBack)

    var title by remember { mutableStateOf("") }

    var favorite by remember { mutableStateOf(false) }

    AndroidTemplateTheme {
        Scaffold(topBar = {
            MyTopAppBar(
                backIcon = Icons.Default.Close,
                titleStr = title,
                clickBack = clickBack,
                actions = {
                    IconButton(onClick = { openArticleInBrowser(url, ctx) }) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_browser),
                            contentDescription = null
                        )
                    }
                    IconButton(onClick = { shareArticle(title, url, ctx) }) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = null
                        )
                    }
                })
        }, floatingActionButton = {
            FloatingActionButton(onClick = { favorite = !favorite }) {
                Icon(
                    imageVector = if (favorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    contentDescription = null,
                    tint = if (favorite) Color.Red else MaterialTheme.colorScheme.primary
                )
            }
        }, floatingActionButtonPosition = FabPosition.Center) { paddingValues ->
            CustomWebView(
                url = url,
                isDarkTheme = isSystemInDarkTheme(),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                clickBack = { canBack ->
                    if (canBack) clickBack()
                }
            ) {
                when (it) {
                    is WebViewEvent.ReceivedTitle -> {
                        title = it.title ?: ""
                    }

                    is WebViewEvent.ProgressChange -> {

                    }

                    is WebViewEvent.PageState -> {

                    }
                }
            }
        }
    }
}

/**
 * 分享文章
 */
fun shareArticle(title: String, url: String, context: Context) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TITLE, title)
        putExtra(Intent.EXTRA_TEXT, url)
    }
    context.startActivity(
        Intent.createChooser(
            intent,
            "分享文章给"
        )
    )
}

/**
 * 在浏览器中打开文章
 */
fun openArticleInBrowser(url: String, context: Context) {
    runCatching {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    }
}
