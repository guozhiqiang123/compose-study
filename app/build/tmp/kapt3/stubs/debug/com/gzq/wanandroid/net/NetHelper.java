package com.gzq.wanandroid.net;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/gzq/wanandroid/net/NetHelper;", "", "()V", "BASE_URL", "", "_httpClient", "Lokhttp3/OkHttpClient;", "_retrofit", "Lretrofit2/Retrofit;", "networkHandler", "Lcom/gzq/wanandroid/core/http/NetworkHandler;", "getNetworkHandler", "()Lcom/gzq/wanandroid/core/http/NetworkHandler;", "setNetworkHandler", "(Lcom/gzq/wanandroid/core/http/NetworkHandler;)V", "service", "Lcom/gzq/wanandroid/WanAndroidApi;", "getService", "()Lcom/gzq/wanandroid/WanAndroidApi;", "setService", "(Lcom/gzq/wanandroid/WanAndroidApi;)V", "init", "", "context", "Landroid/content/Context;", "app_debug"})
public final class NetHelper {
    @org.jetbrains.annotations.NotNull
    public static final com.gzq.wanandroid.net.NetHelper INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String BASE_URL = "https://www.wanandroid.com";
    private static retrofit2.Retrofit _retrofit;
    private static okhttp3.OkHttpClient _httpClient;
    public static com.gzq.wanandroid.WanAndroidApi service;
    public static com.gzq.wanandroid.core.http.NetworkHandler networkHandler;
    
    private NetHelper() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.gzq.wanandroid.WanAndroidApi getService() {
        return null;
    }
    
    public final void setService(@org.jetbrains.annotations.NotNull
    com.gzq.wanandroid.WanAndroidApi p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.gzq.wanandroid.core.http.NetworkHandler getNetworkHandler() {
        return null;
    }
    
    public final void setNetworkHandler(@org.jetbrains.annotations.NotNull
    com.gzq.wanandroid.core.http.NetworkHandler p0) {
    }
    
    public final void init(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
}