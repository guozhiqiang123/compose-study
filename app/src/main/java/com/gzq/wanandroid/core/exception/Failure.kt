package com.gzq.wanandroid.core.exception

/**
 * 自定义错误
 */
sealed class Failure : Throwable() {

    /**
     * 主要给State设置初始状态
     */
    object None : Failure()

    /**
     * 网络错误
     */
    object NetworkError : Failure()

    /**
     * 服务器返回的业务错误
     */
    data class ServerError(val code: Int = 0, val msg: String? = "") : Failure()

    /**
     * 例如数据处理过程中的错误，http协议错误
     */
    data class OtherError(val throwable: Throwable? = null) : Failure()

    /**
     * 接口返回的data字段为空
     */
    object EmptyData : Failure()

}
