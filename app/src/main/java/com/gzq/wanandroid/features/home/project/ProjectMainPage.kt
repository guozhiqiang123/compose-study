package com.gzq.wanandroid.features.home.project

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.gzq.wanandroid.R
import com.gzq.wanandroid.exit_app.MyBackHandler
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
        }) {
            navController.navigate(Router.FreeStylePage.route)
        }
    }
}

@Composable
fun ProjectMainPage(
    modifier: Modifier = Modifier,
    routeGlideImagePage: () -> Unit,
    routeCoilImagePage: () -> Unit,
    routeSketchImagePage: () -> Unit,
    routeFreeStylePage: () -> Unit
) {
    MyBackHandler()
    LazyColumn(
        modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Button(
                onClick = routeGlideImagePage ?: {},
                Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.glide_load_image))
            }
        }
        item {
            Button(
                onClick = routeCoilImagePage ?: {},
                Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.coil_load_image))
            }
        }
        item {
            Button(
                onClick = routeSketchImagePage ?: {},
                Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.sketch_load_image))
            }
        }
        item {
            Button(
                onClick = routeFreeStylePage ?: {},
                Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.free_style_projects))
            }
        }
    }
}