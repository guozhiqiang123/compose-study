package com.gzq.wanandroid.router

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.gzq.wanandroid.features.change_language.changeLanguagePage
import com.gzq.wanandroid.features.change_theme.changeThemePage
import com.gzq.wanandroid.features.details.detailPage
import com.gzq.wanandroid.features.free_style.freeStylePage
import com.gzq.wanandroid.features.home.home.homeMainPage
import com.gzq.wanandroid.features.home.profile.profileMainPage
import com.gzq.wanandroid.features.home.project.pages.coilImagePage
import com.gzq.wanandroid.features.home.project.pages.glideImagePage
import com.gzq.wanandroid.features.home.project.pages.sketchImagePage
import com.gzq.wanandroid.features.home.project.projectMainPage
import com.gzq.wanandroid.features.login.loginPage
import com.gzq.wanandroid.features.register.registerPage

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RouterRegister(
    navController: NavHostController,
    loginController: (Boolean, Boolean) -> Unit,
    showBottomNavigationBar: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Router.HomePage.route,
        modifier = modifier,
        enterTransition = {
            if (targetState.isHomePage()) {
                fadeIn(animationSpec = tween(700))
            } else {
                slideInHorizontally(initialOffsetX = { it })
            }
        },
        exitTransition = {
            fadeOut(animationSpec = tween(700))
        },
        popEnterTransition = {
            fadeIn(animationSpec = tween(700))
        },
        popExitTransition = {
            if (initialState.isHomePage()) {
                fadeOut(animationSpec = tween(700))
            } else {
                slideOutHorizontally(targetOffsetX = { it })
            }
        }
    ) {

        /**
         * 将对应逻辑抽离到对应UI文件中，保持该文件的干净，同时方便后期维护
         */

        homeMainPage(navController, showBottomNavigationBar)

        projectMainPage(navController)

        profileMainPage(navController, loginController, showBottomNavigationBar)

        glideImagePage(navController)

        coilImagePage(navController)

        sketchImagePage(navController)

        detailPage(navController, showBottomNavigationBar)

        loginPage(navController, loginController, showBottomNavigationBar)

        registerPage(navController)

        freeStylePage(navController)

        changeThemePage(navController)

        changeLanguagePage(navController)
    }
}

/**
 * 判断是不是回到主页面
 */
fun NavBackStackEntry.isHomePage(): Boolean {
    return destination.hierarchy.any {
        it.route == Router.HomePage.route
                || it.route == Router.ProjectPage.route
                || it.route == Router.ProfilePage.route
    }
}