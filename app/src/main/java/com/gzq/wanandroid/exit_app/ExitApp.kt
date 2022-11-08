package com.gzq.wanandroid.exit_app

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import com.gzq.wanandroid.features.main.LocalSnackbarHostState
import kotlinx.coroutines.launch

var lastBackTime: Long = 0L

@Composable
fun MyBackHandler(snackbarHostState: SnackbarHostState = LocalSnackbarHostState.current) {

    val ctx = LocalContext.current

    val scope = rememberCoroutineScope()

    BackHandler(enabled = true) {
        val curTime = System.currentTimeMillis()
        if (curTime - lastBackTime > 2000) {
            scope.launch {
                snackbarHostState.showSnackbar("再按一次退出程序")
            }
            lastBackTime = curTime
        } else {
            (ctx as? Activity)?.finish()
        }
    }
}