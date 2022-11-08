package com.gzq.wanandroid.core.quality

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import com.gzq.wanandroid.BuildConfig
import com.gzq.wanandroid.core.log.TAG_RECOMPOSE
import timber.log.Timber

class Ref(var value: Int)

/**
 * 此组件用于调试重组次数，防止过渡重组
 * 注意，此处的 inline 会使下列函数实际上直接内联到调用处
 * 以确保 logging 仅在原始调用位置被调用
 */
@Composable
inline fun LogCompositions(msg: String, tag: String = TAG_RECOMPOSE) {
    if (BuildConfig.DEBUG) {
        val ref = remember { Ref(0) }
        SideEffect { ref.value++ }
        Timber.tag(tag).d("Compositions: $msg  ${ref.value}")
    }
}
