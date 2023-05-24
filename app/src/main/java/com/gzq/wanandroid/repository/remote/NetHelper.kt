package com.gzq.wanandroid.repository.remote

import android.annotation.SuppressLint
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

    private lateinit var retrofit: Retrofit

    private lateinit var httpClient: OkHttpClient

    lateinit var service: WanAndroidApi

    //因为引入的是Application级别的上下文，这里忽略内存泄露
    @SuppressLint("StaticFieldLeak")
    lateinit var networkHandler: NetworkHandler


    fun init(context: Context) {
        httpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE))
            .addInterceptor(ChuckerInterceptor.Builder(context).build())
            .addInterceptor(SetCookieInterceptor())
            .addInterceptor(CacheCookieInterceptor())
            .build()

        retrofit = Retrofit.Builder()
            .client(httpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(WanAndroidApi::class.java)

        networkHandler = NetworkHandler(context)
    }
}