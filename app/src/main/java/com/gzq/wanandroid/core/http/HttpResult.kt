package com.gzq.wanandroid.core.http

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * 默认HttpResult,如果格式和此处有较大差异，可implements BaseModel进行扩展
 */
@Keep
class HttpResult<T> : BaseModel<T>, Serializable {
    @SerializedName(value = "errorCode")
    private val code = -1

    @SerializedName(value = "errorMsg")
    private val message: String? = null

    //用来模仿Data
    @SerializedName(value = "data", alternate = ["subjects", "result", "error"])
    private val data: T? = null

    override fun isSuccess(): Boolean {
        //后台默认0是有效数据，其他皆是异常数据
        return code == 0
    }

    override fun getCode(): Int = code

    override fun getMessage(): String? = message

    override fun getData(): T? = data
}