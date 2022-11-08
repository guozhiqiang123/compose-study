package com.gzq.wanandroid.core.preview

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

/**
 * 定义所有预览文件
 */

@Preview(
    name = "亮色",
    uiMode = UI_MODE_NIGHT_NO,
    showSystemUi = true,
    showBackground = true,
    backgroundColor = 0xFFf0f0f0
)
@Preview(
    name = "暗色",
    uiMode = UI_MODE_NIGHT_YES,
    showSystemUi = true,
    showBackground = true,
    backgroundColor = 0xFF262626
)
annotation class ThemePreviews

@Preview(
    name = "手机",
    showSystemUi = true,
    showBackground = true,
    device = Devices.PHONE
)
@Preview(
    name = "平板",
    showSystemUi = true,
    showBackground = true,
    device = Devices.TABLET
)
annotation class DevicePreviews
