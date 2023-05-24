package com.gzq.wanandroid.features.home.profile

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.gzq.wanandroid.R
import com.gzq.wanandroid.features.open_source_libs.MarkdownPreviewPageArgs
import com.gzq.wanandroid.router.Router

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.profileMainPage(
    navController: NavHostController,
    loginController: (Boolean, Boolean) -> Unit,
    showBottomNavigationBar: (Boolean) -> Unit
) {
    composable(Router.ProfilePage.route) {
        ProfileMainPage(launchLoginPage = {
            showBottomNavigationBar(false)
            navController.navigate(Router.LoginPage.route)
        }, loginController = loginController,
            launchChangeLanguagePage = {
                navController.navigate(Router.ChangeLanguagePage.route)
            }, launchChangeThemePage = {
                navController.navigate(Router.ChangeThemePage.route)
            }, launchOpenSourcePage = {
                showBottomNavigationBar(false)
                navController.navigate(
                    Router.MarkdownPreviewPage.createRoute(
                        MarkdownPreviewPageArgs(
                            "markdown/OpenSourceLibs.md",
                            R.string.use_open_source_libs
                        ).toJson()
                    )
                )
            }, launchProjectDoc = {
                showBottomNavigationBar(false)
                navController.navigate(
                    Router.MarkdownPreviewPage.createRoute(
                        MarkdownPreviewPageArgs(
                            "markdown/ProjectDoc.md",
                            R.string.this_project_docs
                        ).toJson()
                    )
                )
            }, launchTodo = {
                showBottomNavigationBar(false)
                navController.navigate(
                    Router.MarkdownPreviewPage.createRoute(
                        MarkdownPreviewPageArgs(
                            "markdown/ToDo.md",
                            R.string.todo
                        ).toJson()
                    )
                )
            }, launchWebPage = { url ->
                showBottomNavigationBar(false)
                navController.navigate(Router.WebViewPage.createRoute(url))
            }, launchCollectionPage = {
                showBottomNavigationBar(false)
                navController.navigate(Router.CollectionPage.route)
            }, launchSharePage = {

            }, launchIntegralPage = {

            }, launchHistoryPage = {

            }, launchMessagePage = {

            })
    }
}