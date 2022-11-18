package com.gzq.wanandroid.features.open_source_libs

import android.os.Parcelable
import androidx.activity.compose.BackHandler
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavArgs
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.composable
import com.gzq.wanandroid.R
import com.gzq.wanandroid.core.gson.GsonUtils
import com.gzq.wanandroid.core.page.PageState
import com.gzq.wanandroid.router.Router
import com.gzq.wanandroid.widget.Markdown
import com.gzq.wanandroid.widget.MyTopAppBar
import com.gzq.wanandroid.widget.PageHolder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.parcelize.Parcelize


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.openSourceLibsPage(
    navController: NavHostController,
    showBottomNavigationBar: (Boolean) -> Unit
) {
    composable(Router.MarkdownPreviewPage.route) {
        MarkdownPreviewPage(
            args = GsonUtils.gson.fromJson(
                it.arguments?.getString("args"),
                MarkdownPreviewPageArgs::class.java
            ),
            clickBack = {
                showBottomNavigationBar(true)
                navController.popBackStack()
            })
    }
}

@Parcelize
data class MarkdownPreviewPageArgs(val path: String, val pageNameId: Int) : Parcelable {
    fun toJson(): String = GsonUtils.gson.toJson(this)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarkdownPreviewPage(
    args: MarkdownPreviewPageArgs,
    clickBack: () -> Unit
) {

    BackHandler(onBack = clickBack)

    Scaffold(topBar = {
        MyTopAppBar(
            titleStr = stringResource(id = args.pageNameId),
            clickBack = clickBack
        )
    }) { paddingValues ->

        var pageState: PageState<String> by remember { mutableStateOf(PageState.Loading) }

        val scope = rememberCoroutineScope()

        val ctx = LocalContext.current
        DisposableEffect(Unit) {
            val job = scope.launch(Dispatchers.IO) {
                ctx.assets.open(args.path).bufferedReader().use {
                    val result = it.readLines().joinToString(separator = "\n")
                    pageState = PageState.Success(result)
                }
            }
            onDispose {
                job.cancel()
            }
        }

        PageHolder(pageState = pageState) { data ->
            Box(
                Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                Markdown(markdown = data ?: "", Modifier.fillMaxSize())
            }
        }
    }
}