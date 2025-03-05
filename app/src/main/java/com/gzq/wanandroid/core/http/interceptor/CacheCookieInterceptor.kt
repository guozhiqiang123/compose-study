package com.gzq.wanandroid.core.http.interceptor

import com.gzq.wanandroid.LocalKey.KEY_LOGIN_COOKIE
import com.tencent.mmkv.MMKV
import okhttp3.Interceptor
import okhttp3.Response

class CacheCookieInterceptor : Interceptor {

    private val loginUrl = "user/login"
    private val registerUrl = "user/register"
    private val SET_COOKIE_KEY = "set-cookie"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        val requestUrl = request.url.toString()

        // 检查请求是否与登录或注册相关
        if (isUserRelatedUrl(requestUrl)) {
            val cookies = response.headers(SET_COOKIE_KEY)
            if (cookies.isNotEmpty()) {
                // 如果有cookie，进行处理并保存
                saveCookies(cookies)
            }
        }

        return response
    }

    /**
     * 检查URL是否与登录或注册相关
     */
    private fun isUserRelatedUrl(url: String): Boolean =
        listOf(loginUrl, registerUrl).any { url.contains(it) }

    /**
     * 保存cookie到MMKV
     */
    private fun saveCookies(cookies: List<String>) {
        val encodedCookies = encodeCookie(cookies)
        MMKV.defaultMMKV().encode(KEY_LOGIN_COOKIE, encodedCookies)
    }
}

/**
 * 对cookie进行编码：按分号分割、去重、去掉尾部分号
 */
private fun encodeCookie(cookies: List<String>): String {
    return cookies
        .flatMap { it.split(";".toRegex()) } // 按分号拆分cookie
        .map { it.trim() } // 去除每个cookie值的空格
        .distinct() // 去重
        .joinToString(";") // 使用分号连接
        .removeSuffix(";") // 去掉尾部的分号
}

