package com.gzq.wanandroid.features.change_language

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.gzq.wanandroid.MainActivity
import com.gzq.wanandroid.router.Router
import com.gzq.wanandroid.widget.MyTopAppBar
import com.yariksoffice.lingver.Lingver
import java.util.Locale


fun NavGraphBuilder.changeLanguagePage(
    navController: NavHostController
) {
    composable(Router.ChangeLanguagePage.route) {
        ChangeThemePage(clickBack = {
            navController.popBackStack()
        })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangeThemePage(clickBack: () -> Unit) {

    var language by remember {
        mutableStateOf(Lingver.getInstance().getLocale())
    }

    var hasChange by remember { mutableStateOf(false) }

    val ctx = LocalContext.current

    if (hasChange) {
        DisposableEffect(Unit) {
            Intent(ctx, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            }.also { ctx.startActivity(it) }

            onDispose { }
        }
    }

    Scaffold(topBar = {
        MyTopAppBar(titleStr = "切换语言", clickBack = clickBack)
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .clickable {
                        if (Lingver
                                .getInstance()
                                .isFollowingSystemLocale()
                        ) return@clickable
                        Lingver
                            .getInstance()
                            .setFollowSystemLocale(ctx)
                        hasChange = true
                    }
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "跟随系统", modifier = Modifier.weight(1.0f))
                RadioButton(
                    selected = Lingver.getInstance().isFollowingSystemLocale(),
                    onClick = null
                )
            }
            Divider(Modifier.padding(horizontal = 16.dp))
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .clickable {
                        if (language == Locale.SIMPLIFIED_CHINESE &&
                            !Lingver
                                .getInstance()
                                .isFollowingSystemLocale()
                        ) return@clickable
                        language = Locale.SIMPLIFIED_CHINESE
                        Lingver
                            .getInstance()
                            .setLocale(ctx, Locale.SIMPLIFIED_CHINESE)
                        hasChange = true
                    }
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "中文", modifier = Modifier.weight(1.0f))
                RadioButton(
                    selected = language == Locale.SIMPLIFIED_CHINESE &&
                            !Lingver.getInstance().isFollowingSystemLocale(),
                    onClick = null
                )
            }
            Divider(Modifier.padding(horizontal = 16.dp))
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .clickable {
                        if (language == Locale.ENGLISH) return@clickable
                        language = Locale.ENGLISH
                        Lingver
                            .getInstance()
                            .setLocale(ctx, Locale.ENGLISH)
                        hasChange = true
                    }
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "英文", modifier = Modifier.weight(1.0f))
                RadioButton(selected = language == Locale.ENGLISH, onClick = null)
            }
            Divider(Modifier.padding(horizontal = 16.dp))
        }
    }
}