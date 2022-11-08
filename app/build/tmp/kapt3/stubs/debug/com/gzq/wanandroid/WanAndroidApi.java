package com.gzq.wanandroid;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J-\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/gzq/wanandroid/WanAndroidApi;", "", "getHomeList", "Lcom/gzq/wanandroid/core/http/HttpResult;", "Lcom/gzq/wanandroid/model/HomeList;", "page", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginWithPassword", "Lcom/gzq/wanandroid/model/UserInfo;", "userName", "", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface WanAndroidApi {
    
    /**
     * 首页内容
     */
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "/article/list/{page}/json")
    public abstract java.lang.Object getHomeList(@retrofit2.http.Path(value = "page")
    int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.gzq.wanandroid.core.http.HttpResult<com.gzq.wanandroid.model.HomeList>> continuation);
    
    /**
     * 使用密码登录
     */
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/user/login")
    @retrofit2.http.FormUrlEncoded
    public abstract java.lang.Object loginWithPassword(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Field(value = "username")
    java.lang.String userName, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Field(value = "password")
    java.lang.String password, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.gzq.wanandroid.core.http.HttpResult<com.gzq.wanandroid.model.UserInfo>> continuation);
    
    /**
     * 退出登录
     */
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "/user/logout/json")
    public abstract java.lang.Object logout(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.gzq.wanandroid.core.http.HttpResult> continuation);
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
    public final class DefaultImpls {
    }
}