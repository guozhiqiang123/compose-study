package com.gzq.wanandroid.features.home.project

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.gzq.wanandroid.router.Router

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.projectMainPage(
    navController: NavHostController,
) {
    composable(Router.ProjectPage.route) {
        ProjectMainPage(routeGlideImagePage = {
            navController.navigate(Router.GlideImagePage.route)
        }, routeCoilImagePage = {
            navController.navigate(Router.CoilImagePage.route)
        }, routeSketchImagePage = {
            navController.navigate(Router.SketchImagePage.route)
        }, routeFreeStylePage = {
            navController.navigate(Router.FreeStylePage.route)
        }, routeTestClickPage = {
            navController.navigate(Router.TestClickPage.route)
        })
    }
}