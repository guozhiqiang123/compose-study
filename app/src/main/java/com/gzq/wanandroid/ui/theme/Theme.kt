package com.gzq.wanandroid.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import com.gzq.wanandroid.LocalKey
import com.tencent.mmkv.MMKV


enum class Theme {
    Default, Green, Purple
}


/**
 * 保存全局主题
 */
val themeState by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    val themeString = MMKV.defaultMMKV().decodeString(LocalKey.KEY_USER_THEME, Theme.Default.name)
    mutableStateOf(Theme.valueOf(themeString ?: "default"))
}

@Composable
fun AndroidTemplateTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {

    val theme by remember { themeState }

    val lightColors = when (theme) {
        Theme.Default -> LightColors
        Theme.Green -> com.gzq.wanandroid.ui.theme.green.LightColors
        Theme.Purple -> com.gzq.wanandroid.ui.theme.purple.LightColors

    }
    val darkColors = when (theme) {
        Theme.Default -> DarkColors
        Theme.Green -> com.gzq.wanandroid.ui.theme.green.DarkColors
        Theme.Purple -> com.gzq.wanandroid.ui.theme.purple.DarkColors
    }

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> darkColors
        else -> lightColors
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}