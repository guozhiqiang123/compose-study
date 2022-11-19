package com.gzq.wanandroid.features.webview

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.gzq.wanandroid.router.Router
import com.gzq.wanandroid.router.isHomePage
import com.gzq.wanandroid.ui.theme.AndroidTemplateTheme
import com.gzq.wanandroid.widget.CustomWebView
import com.gzq.wanandroid.widget.MyTopAppBar
import com.gzq.wanandroid.widget.WebViewEvent

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.webviewPage(
    navController: NavHostController,
    showBottomNavigationBar: (Boolean) -> Unit
) {
    composable(Router.WebViewPage.route) {
        WebViewPage(
            url = it.arguments?.getString("url")
                ?: throw IllegalArgumentException("url不能为空")
        ) {
            showBottomNavigationBar(navController.previousBackStackEntry!!.isHomePage())
            navController.popBackStack()
        }
    }
}

/**
 * 通用webview，传递url即可显示
 */
@SuppressLint("SetJavaScriptEnabled")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WebViewPage(url: String, clickBack: () -> Unit) {

    //将我们自己的返回点击代理给系统
    //否则点击物理返回按钮不会执行showBottomNavigation的逻辑
    BackHandler(onBack = clickBack)

    var title by remember { mutableStateOf("") }

    var favorite by remember { mutableStateOf(false) }

    AndroidTemplateTheme {
        Scaffold(topBar = {
            MyTopAppBar(
                backIcon = Icons.Default.Close,
                title = title,
                clickBack = clickBack
            )
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