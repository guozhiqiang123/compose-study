package com.gzq.wanandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import com.gzq.wanandroid.core.log.TAG_INFO
import com.gzq.wanandroid.core.log.TAG_LIFECYCLE
import com.gzq.wanandroid.features.main.MainPage
import com.gzq.wanandroid.features.main.rememberAppState
import timber.log.Timber


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_AndroidTemplate)
        super.onCreate(savedInstanceState)

        Timber.tag(TAG_LIFECYCLE).d("onCreate")
        setContent {
            val windowSizeClass = calculateWindowSizeClass(this)
            val appState = rememberAppState(windowSizeClass = windowSizeClass)
            val navHostController = appState.navController
            val currentBackStackEntryAsState by navHostController.currentBackStackEntryAsState()
            LaunchedEffect(navHostController, currentBackStackEntryAsState) {
//                Timber.tag(TAG_INFO)
//                    .d(
//                        "当前页面栈信息：${currentBackStackEntryAsState?.destination?.route}," +
//                                "栈内页面数量：${navHostController.backQueue.map { it.destination.route }}"
//                    )
            }
            MainPage(windowSizeClass, appState = appState)
        }
    }
}