@file:Suppress("UNCHECKED_CAST")

package com.gzq.wanandroid.core.extension

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.distinctUntilChanged
import timber.log.Timber

/**
 * livedata防抖
 */
@Composable
fun <T> LiveData<T>.observeUniqueOnlyState(): State<T?> {
    return this.distinctUntilChanged().observeAsState()
}

/**
 * 该方式目前能解决[Composable]中，[LiveData]数据倒灌的问题。
 * 注意：该方式不是很优雅，后面我学习到更加优秀的方案，再来替换。
 */
@Composable
fun <T> LiveData<T>.observeAutoResetAsState(): State<T?> = observeAutoResetAsState(value)

/**
 * 为了解决使用[LaunchedEffect]等副作用，在屏幕旋转、页面重新进入前台等情况下，出现观察[LiveData]数据倒灌的问题。
 * 注意：该方式不是很优雅，后面我学习到更加优秀的方案，再来替换。
 * 在onDispose中直接把LiveData的值再次设置为初始值。
 */
@Composable
private fun <R, T : R> LiveData<T>.observeAutoResetAsState(initial: R): State<R> {
    val initialValue = remember { initial }
    val lifecycleOwner = LocalLifecycleOwner.current
    val state = remember { mutableStateOf(initial) }
    DisposableEffect(this, lifecycleOwner) {
        val observer = Observer<T> { state.value = it }
        observe(lifecycleOwner, observer)
        onDispose {
            removeObserver(observer)
            (this@observeAutoResetAsState as? MutableLiveData<T>)?.value = (initialValue as T?)
        }
    }
    return state
}
