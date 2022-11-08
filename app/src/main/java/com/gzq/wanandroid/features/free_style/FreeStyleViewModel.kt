package com.gzq.wanandroid.features.free_style

import com.gzq.wanandroid.core.base.BaseViewModel
import timber.log.Timber

class FreeStyleViewModel : BaseViewModel() {
    suspend fun testFunc() {
        Timber.tag("ProfileMainViewModel").d("执行了")
    }
}