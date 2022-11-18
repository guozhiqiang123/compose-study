package com.gzq.wanandroid.net

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.gzq.wanandroid.repository.WanAndroidApi
import com.gzq.wanandroid.core.http.NetworkHandler
import com.gzq.wanandroid.core.http.interceptor.CacheCookieInterceptor
import com.gzq.wanandroid.core.http.interceptor.SetCookieInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetHelper {
    const val BASE_URL = "https://www.wanandroid.com"

    private lateinit var _retrofit: Retrofit

    private lateinit var _httpClient: OkHttpClient

    lateinit var service: WanAndroidApi

    lateinit var networkHandler: NetworkHandler


    fun init(context: Context) {
        _httpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE))
            .addInterceptor(ChuckerInterceptor.Builder(context).build())
            .addInterceptor(SetCookieInterceptor())
            .addInterceptor(CacheCookieInterceptor())
            .build()

        _retrofit = Retrofit.Builder()
            .client(_httpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = _retrofit.create(WanAndroidApi::class.java)

        networkHandler = NetworkHandler(context)
    }
}