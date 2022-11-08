package com.gzq.wanandroid.core.http.interceptor

import com.gzq.wanandroid.LocalKey
import com.tencent.mmkv.MMKV
import okhttp3.Interceptor
import okhttp3.Response

class SetCookieInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
        val domain = request.url.host
        //获取domain内的cookie
        if (domain.isNotEmpty()) {
            val cookie=MMKV.defaultMMKV().decodeString(LocalKey.KEY_LOGIN_COOKIE) ?:""
            if (cookie.isNotEmpty()) {
                builder.addHeader("Cookie", cookie)
            }
        }
        return chain.proceed(builder.build())
    }
}