package com.gzq.wanandroid.core.extension

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * 一些错误逻辑，比如登录时候，密码错误，多次调用登录接口，应该都能弹出错误提示。
 * 也就是各种监听不应该被防抖。
 * 所以针对这种情况，单独封装了这个Effect。该Effect只能配合LiveData使用，如果需要配合Flow使用，请自行封装。
 * @param key1 必须是LiveData
 * @param keys 其他key
 * @param reset 是否在生命周期结束的时候重置LiveData的值
 * @param block 协程体
 */
@Composable
fun <T> DisposableRepeatEffect(
    key1: LiveData<T?>,
    vararg keys: Any?,
    reset: Boolean = false,
    block: suspend CoroutineScope.(T?) -> Unit
) {
    val initialValue = remember { key1.value }
    val lifecycleOwner = LocalLifecycleOwner.current
    val scope = rememberCoroutineScope()
    var job by remember { mutableStateOf<Job?>(null) }

    DisposableEffect(key1, *keys) {
        val observer = Observer<T?> { value ->
            job?.cancel()
            job = scope.launch { block(value) }
        }
        key1.observe(lifecycleOwner, observer)
        onDispose {
            key1.removeObserver(observer)
            job?.cancel()
            if (reset) (key1 as MutableLiveData<T?>).value = initialValue
        }
    }
}