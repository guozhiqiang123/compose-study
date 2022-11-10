package com.gzq.wanandroid.core.page

/**
 * 描述页面状态
 */
sealed class PageState<out T> {
    /**
     * 成功
     * @param data 页面模型
     */
    data class Success<T>(val data: T? = null) : PageState<T>()

    /**
     * 出错
     * @param throwable 错误信息
     * @param value 额外信息
     */
    data class Error(
        val throwable: Throwable? = null,
        val value: Any? = null
    ) : PageState<Nothing>()

    /**
     * 正在加载
     */
    object Loading : PageState<Nothing>()

    /**
     * 空数据
     * @param value 额外信息
     */
    data class Empty(val value: Any? = null) : PageState<Nothing>()

    /**
     * 正在开发
     * 只适用于demo，生产项目一般不会有这种情况
     */
    object ComingSoon : PageState<Nothing>()
}