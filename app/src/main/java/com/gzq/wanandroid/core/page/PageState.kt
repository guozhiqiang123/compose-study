package com.gzq.wanandroid.core.page

/**
 * 描述页面状态
 */
sealed class PageState<out T> {
    data class Success<T>(val data: T? = null) : PageState<T>()

    data class Error(
        val throwable: Throwable? = null,
        val value: Any? = null
    ) : PageState<Nothing>()

    object Loading : PageState<Nothing>()

    data class Empty(val value: Any? = null) : PageState<Nothing>()

    object ComingSoon : PageState<Nothing>()
}