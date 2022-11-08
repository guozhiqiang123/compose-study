package com.gzq.wanandroid.features.register

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.gzq.wanandroid.core.page.PageState
import com.gzq.wanandroid.router.Router
import com.gzq.wanandroid.ui.theme.AndroidTemplateTheme
import com.gzq.wanandroid.widget.PageHolder


fun NavGraphBuilder.registerPage(
    navController: NavHostController
) {
    composable(Router.RegisterPage.route) {
        RegisterPage()
    }
}

@Composable
fun RegisterPage() {
    AndroidTemplateTheme {
        PageHolder(pageState = PageState.ComingSoon) {

        }
    }
}