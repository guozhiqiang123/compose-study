package com.gzq.wanandroid.features.open_source_libs

import androidx.activity.compose.BackHandler
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.gzq.wanandroid.R
import com.gzq.wanandroid.core.page.PageState
import com.gzq.wanandroid.router.Router
import com.gzq.wanandroid.widget.Markdown
import com.gzq.wanandroid.widget.MyTopAppBar
import com.gzq.wanandroid.widget.PageHolder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.openSourceLibsPage(
    navController: NavHostController,
    showBottomNavigationBar: (Boolean) -> Unit
) {
    composable(Router.OpenSourceLibsPage.route) {
        OpenSourceLibsPage(clickBack = {
            showBottomNavigationBar(true)
            navController.popBackStack()
        })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OpenSourceLibsPage(clickBack: () -> Unit) {

    BackHandler(onBack = clickBack)

    val isDarkModel = isSystemInDarkTheme()

    val textColor =
        if (isDarkModel) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.onSurface


    val codeBackground = MaterialTheme.colorScheme.onPrimaryContainer.toArgb()
    val codeColor = MaterialTheme.colorScheme.primaryContainer.toArgb()

    Scaffold(topBar = {
        MyTopAppBar(
            titleStr = stringResource(id = R.string.use_open_source_libs),
            clickBack = clickBack
        )
    }) { paddingValues ->

        var pageState: PageState<String> by remember { mutableStateOf(PageState.Loading) }

        val scope = rememberCoroutineScope()

        val ctx = LocalContext.current
        DisposableEffect(Unit) {
            val job = scope.launch(Dispatchers.IO) {
                ctx.assets.open("markdown/OpenSourceLibs.md").bufferedReader().use {
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
                Markdown(markdown = data ?: "",Modifier.fillMaxSize())
            }
        }
    }
}