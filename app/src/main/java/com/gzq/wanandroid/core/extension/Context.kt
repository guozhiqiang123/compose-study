package com.zlcoder.core.extension

import android.app.UiModeManager
import android.content.ClipData
import android.content.ClipboardManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.net.ConnectivityManager
import android.widget.Toast


/**
 * 获取CONNECTIVITY_SERVICE服务的扩展
 */
val Context.connectivityManager: ConnectivityManager
    get() = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

/**
 * 启动微信
 */
fun Context.launchWeChat(): Boolean {
    return try {
        Intent().apply {
            action = Intent.ACTION_MAIN
            addCategory(Intent.CATEGORY_LAUNCHER)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            component = ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI")
        }.also { startActivity(it) }
        true
    } catch (e: Exception) {
        false
    }
}

/**
 * 将内容复制到剪贴板
 */
fun Context.copyToClipboard(text: String) {
    (getSystemService(Context.CLIPBOARD_SERVICE) as? ClipboardManager)?.setPrimaryClip(
        ClipData.newPlainText(null, text))
}

/**
 * 当前APP是不是暗黑模式
 */
fun Context.isAppNightMode(): Boolean =
    (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES

/**
 * 系统是否是暗黑模式
 */
fun Context.isSystemNightMode(): Boolean =
    (getSystemService(Context.UI_MODE_SERVICE) as UiModeManager).nightMode == UiModeManager.MODE_NIGHT_YES

/**
 * 屏幕是否是横屏
 */
fun Context.isScreenLandscape(): Boolean =
    applicationContext.resources.configuration.orientation == ORIENTATION_LANDSCAPE

/**
 * toast
 * @param any object
 */
fun Context.toast(any: Any? = null) {
    Toast.makeText(this, "$any", Toast.LENGTH_SHORT).show()
}