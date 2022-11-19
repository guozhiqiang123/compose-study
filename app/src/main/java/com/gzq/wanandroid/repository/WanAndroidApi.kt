package com.gzq.wanandroid.repository

import com.gzq.wanandroid.model.HomeList
import com.gzq.wanandroid.core.http.HttpResult
import com.gzq.wanandroid.model.Article
import com.gzq.wanandroid.model.CollectionArticles
import com.gzq.wanandroid.model.UserInfo
import com.gzq.wanandroid.model.UserShareList
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface WanAndroidApi {
    /**
     * 首页内容
     */
    @GET("/article/list/{page}/json")
    suspend fun getHomeList(@Path("page") page: Int = 0): HttpResult<HomeList?>

    /**
     * 使用密码登录
     */
    @FormUrlEncoded
    @POST("/user/login")
    suspend fun loginWithPassword(
        @Field("username") userName: String,
        @Field("password") password: String
    ): HttpResult<UserInfo?>

    /**
     * 退出登录
     */
    @GET("/user/logout/json")
    suspend fun logout(): HttpResult<Nothing?>

    /**
     * 注册
     */
    @FormUrlEncoded
    @POST("/user/register")
    suspend fun register(
        @Field("username") userName: String,
        @Field("password") password: String,
        @Field("repassword") repassword: String,
    ): HttpResult<UserInfo?>

    /**
     * 自己的分享、积分等信息
     */
    @GET("/user/lg/private_articles/{page}/json")
    suspend fun myShare(@Path("page") page: Int): HttpResult<UserShareList?>

    /**
     * 我的收藏
     */
    @GET("lg/collect/list/{page}/json")
    suspend fun myCollection(@Path("page") page: Int): HttpResult<CollectionArticles?>
}