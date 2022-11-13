package com.gzq.wanandroid.features.main

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavOptionsBuilder
import com.gzq.wanandroid.LocalKey
import com.gzq.wanandroid.R
import com.gzq.wanandroid.core.quality.LogCompositions
import com.gzq.wanandroid.features.main.components.BottomNavigationC
import com.gzq.wanandroid.features.main.components.DrawableContentC
import com.gzq.wanandroid.features.main.custom.DrawerShape
import com.gzq.wanandroid.router.Router
import com.gzq.wanandroid.router.RouterRegister
import com.gzq.wanandroid.ui.theme.AndroidTemplateTheme
import com.gzq.wanandroid.widget.CustomSnackBar
import com.tencent.mmkv.MMKV
import kotlinx.coroutines.launch

val LocalLoginState = staticCompositionLocalOf { false }

val LocalSnackbarHostState = compositionLocalOf { SnackbarHostState() }

data class BottomNavigationModel(
    val tag: HomeNav,
    @StringRes val labelId: Int,
    val selectIcon: ImageVector,
    val unSelectIcon: ImageVector,
)

val bottomModels = listOf(
    BottomNavigationModel(
        tag = HomeNav.HOME,
        labelId = R.string.nav_home,
        selectIcon = Icons.Default.Home,
        unSelectIcon = Icons.Outlined.Home,
    ),
    BottomNavigationModel(
        tag = HomeNav.PROJECT,
        labelId = R.string.nav_project,
        selectIcon = Icons.Default.Build,
        unSelectIcon = Icons.Outlined.Build,
    ),
    BottomNavigationModel(
        tag = HomeNav.PROFILE,
        labelId = R.string.nav_profile,
        selectIcon = Icons.Default.Person,
        unSelectIcon = Icons.Outlined.Person,
    ),
)

@Composable
fun MainPage(
    windowSizeClass: WindowSizeClass,
    appState: AppState = rememberAppState(windowSizeClass)
) {

    val selectNav = rememberSaveable { mutableStateOf(HomeNav.HOME) }

    val isLogin = remember {
        mutableStateOf(MMKV.defaultMMKV().getBoolean(LocalKey.KEY_IS_LOGIN, false))
    }

    var showNavigationBar by rememberSaveable { mutableStateOf(true) }

    val scaffoldState = rememberScaffoldState()

    val scope = rememberCoroutineScope()

    val snackbarHostState = remember { SnackbarHostState() }

    LogCompositions(msg = "MainPage")

    AndroidTemplateTheme {
        androidx.compose.material.Scaffold(
            scaffoldState = scaffoldState,
            //因为使用的androidx.compose.material.Scaffold
            //所以使用不到主题颜色
            backgroundColor = MaterialTheme.colorScheme.background,
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState) { data ->
                    CustomSnackBar(data = data)
                }
            },
            drawerContent = if (!appState.shouldShowBottomBar && showNavigationBar) {
                {
                    DrawableContentC(isSelect = { model ->
                        selectNav.value == model.tag
                    }) { model ->
                        if (scaffoldState.drawerState.isOpen) {
                            scope.launch { scaffoldState.drawerState.close() }
                        }
                        selectNav.value = model.tag
                        appState.navController.navigate(
                            when (model.tag) {
                                HomeNav.HOME -> Router.HomePage.route
                                HomeNav.PROJECT -> Router.ProjectPage.route
                                HomeNav.PROFILE -> Router.ProfilePage.route
                            }
                        ) {
                            commonSetup(appState.navController)
                        }
                    }
                }
            } else null,
            drawerShape = DrawerShape(
                widthPercent = .618f,
                topEnd = CornerSize(12.dp),
                bottomEnd = CornerSize(12.dp)
            ),
            bottomBar = {
                AnimatedVisibility(
                    visible = appState.shouldShowBottomBar && showNavigationBar,
                    enter = expandHorizontally() + fadeIn(),
                    exit = shrinkVertically() + fadeOut()
                ) {
                    BottomNavigationC(isSelect = { model ->
                        selectNav.value == model.tag
                    }) { model ->
                        selectNav.value = model.tag
                        appState.navController.navigate(
                            when (model.tag) {
                                HomeNav.HOME -> Router.HomePage.route
                                HomeNav.PROJECT -> Router.ProjectPage.route
                                HomeNav.PROFILE -> Router.ProfilePage.route
                            }
                        ) {
                            commonSetup(appState.navController)
                        }
                    }
                }
            }) { paddingValues ->
            CompositionLocalProvider(
                LocalLoginState provides isLogin.value,
                LocalSnackbarHostState provides snackbarHostState
            ) {
                LogCompositions(msg = "CompositionLocalProvider")
                RouterRegister(
                    navController = appState.navController,
                    loginController = { loginState, showBottomNav ->
                        isLogin.value = loginState
                        showNavigationBar = showBottomNav
                    },
                    showBottomNavigationBar = {
                        showNavigationBar = it
                    },
                    Modifier.padding(paddingValues)
                )
            }
        }
    }

}

private fun NavOptionsBuilder.commonSetup(navController: NavController) {
    //避免 BackStack 增长，跳转页面时，将栈内 startDestination 之外的页面弹出
    popUpTo(navController.graph.findStartDestination().id) {
        saveState = true
    }
    //跟activity的启动模式中的SingleTop模式一样 避免在栈顶创建多个实例
    launchSingleTop = true
    //切换状态的时候保存页面状态
    restoreState = true
}


enum class HomeNav {
    HOME, PROJECT, PROFILE
}

//=========================================预览====================================================
@Preview
@Composable
fun MainPagePreview(
    @PreviewParameter(MainPageParameterProvider::class, limit = 1) windowSizeClass: WindowSizeClass
) {
    MainPage(windowSizeClass = windowSizeClass)
}

class MainPageParameterProvider : PreviewParameterProvider<WindowSizeClass> {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override val values = sequenceOf(WindowSizeClass.calculateFromSize(DpSize(411.dp, 891.dp)))
}