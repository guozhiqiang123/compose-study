package com.gzq.wanandroid.features.change_theme

import android.os.Build
import android.text.style.DynamicDrawableSpan
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
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.gzq.wanandroid.LocalKey
import com.gzq.wanandroid.R
import com.gzq.wanandroid.router.Router
import com.gzq.wanandroid.ui.theme.Theme
import com.gzq.wanandroid.ui.theme.dynamicThemeState
import com.gzq.wanandroid.ui.theme.themeState
import com.gzq.wanandroid.widget.MyTopAppBar
import com.tencent.mmkv.MMKV


fun NavGraphBuilder.changeThemePage(
    navController: NavHostController
) {
    composable(Router.ChangeThemePage.route) {
        ChangeThemePage(clickBack = {
            navController.popBackStack()
        })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangeThemePage(clickBack: () -> Unit) {

    Scaffold(topBar = {
        MyTopAppBar(titleStr = stringResource(id = R.string.change_theme), clickBack = clickBack)
    }) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            //处理material3的动态主题
            if (dynamicThemeState.value && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                DynamicThemeC()
            } else {
                StaticThemeC()
                DynamicThemeC()
            }
        }
    }
}

@Composable
fun StaticThemeC() {
    var theme by remember { themeState }

    DisposableEffect(theme) {
        MMKV.defaultMMKV().encode(LocalKey.KEY_USER_THEME, theme.name)
        onDispose { }
    }

    Row(
        Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable { theme = Theme.Default }
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.theme_default),
            modifier = Modifier.weight(1.0f)
        )
        RadioButton(selected = theme == Theme.Default, onClick = null)
    }
    Divider(Modifier.padding(horizontal = 16.dp))
    Row(
        Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable { theme = Theme.Green }
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.theme_green),
            modifier = Modifier.weight(1.0f)
        )
        RadioButton(selected = theme == Theme.Green, onClick = null)
    }
    Divider(Modifier.padding(horizontal = 16.dp))
    Row(
        Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable { theme = Theme.Purple }
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.theme_purple),
            modifier = Modifier.weight(1.0f)
        )
        RadioButton(selected = theme == Theme.Purple, onClick = null)
    }
    Divider(Modifier.padding(horizontal = 16.dp))
}

@Composable
fun DynamicThemeC() {
    var dynamicTheme by remember { dynamicThemeState }

    DisposableEffect(dynamicTheme) {
        MMKV.defaultMMKV().encode(LocalKey.KEY_DYNAMIC_COLOR, dynamicTheme)
        onDispose { }
    }

    Row(
        Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.dynamic_theme),
            modifier = Modifier.weight(1.0f)
        )
        Switch(checked = dynamicTheme, onCheckedChange = {
            dynamicTheme = it
        })
    }

    Divider(Modifier.padding(horizontal = 16.dp))
}