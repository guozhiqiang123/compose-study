package com.gzq.wanandroid.router

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
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

@Composable
fun RouterRegister(
    navController: NavHostController,
    loginController: (Boolean, Boolean) -> Unit,
    showBottomNavigationBar: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Router.HomePage.route,
        modifier = modifier
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
    }
}

/**
 * 判断是不是回到主页面
 */
fun NavBackStackEntry.isHomePage(): Boolean {
    val route = this.destination.route
    return route == Router.HomePage.route
            || route == Router.ProjectPage.route
            || route == Router.ProfilePage.route
}