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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.gzq.wanandroid.R
import com.gzq.wanandroid.core.gson.GsonUtils
import com.gzq.wanandroid.features.main.LocalLoginState
import com.gzq.wanandroid.model.Article
import com.gzq.wanandroid.repository.local.RoomHelp
import com.gzq.wanandroid.router.Router
import com.gzq.wanandroid.router.isHomePage
import com.gzq.wanandroid.ui.theme.AndroidTemplateTheme
import com.gzq.wanandroid.widget.CustomWebView
import com.gzq.wanandroid.widget.MyTopAppBar
import com.gzq.wanandroid.widget.WebViewEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.detailPage(
    navController: NavHostController,
    showBottomNavigationBar: (Boolean) -> Unit
) {
    composable(Router.DetailPage.route) {
        DetailPage(
            data = GsonUtils.gson.fromJson(it.arguments?.getString("args"), Article::class.java)
        ) {
            showBottomNavigationBar(navController.previousBackStackEntry!!.isHomePage())
            navController.popBackStack()
        }
    }
}

@SuppressLint("SetJavaScriptEnabled")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailPage(data: Article?, clickBack: () -> Unit) {
    if (data == null) return

    //???????????????
    //???????????????????????????10???????????????????????????
    if (LocalLoginState.current) {
        val scope = rememberCoroutineScope()
        DisposableEffect(Unit) {
            val job = scope.launch(Dispatchers.IO) {
                delay(10000)
                val mData = data.copy(updateTime = System.currentTimeMillis())
                RoomHelp.db.articleDao().insertAll(mData)
            }
            onDispose {
                job.cancel()
            }
        }
    }

    val ctx = LocalContext.current

    //?????????????????????????????????????????????
    //??????????????????????????????????????????showBottomNavigation?????????
    BackHandler(onBack = clickBack)

    var title by remember { mutableStateOf("") }

    var favorite by remember { mutableStateOf(false) }

    AndroidTemplateTheme {
        Scaffold(topBar = {
            MyTopAppBar(
                backIcon = Icons.Default.Close,
                title = title,
                clickBack = clickBack,
                actions = {
                    IconButton(onClick = { openArticleInBrowser(data.link, ctx) }) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_browser),
                            contentDescription = null
                        )
                    }
                    IconButton(onClick = { shareArticle(title, data.link, ctx) }) {
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
                url = data.link,
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
 * ????????????
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
            "???????????????"
        )
    )
}

/**
 * ???????????????????????????
 */
fun openArticleInBrowser(url: String, context: Context) {
    runCatching {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    }
}
