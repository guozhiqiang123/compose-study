package com.gzq.wanandroid.core.http.interceptor

import com.gzq.wanandroid.LocalKey
import com.tencent.mmkv.MMKV
import okhttp3.Interceptor
import okhttp3.Response

class SetCookieInterceptor : Interceptor {

    private val mmkv by lazy { MMKV.defaultMMKV() }

    override fun intercept(chain: Interceptor.Chain): Response {
        val cookie = mmkv.decodeString(LocalKey.KEY_LOGIN_COOKIE)
            ?.takeIf { it.isNotEmpty() } ?: return chain.proceed(chain.request())

        return chain.proceed(
            chain.request()
                .newBuilder()
                .addHeader("Cookie", cookie)
                .build()
        )
    }
}

