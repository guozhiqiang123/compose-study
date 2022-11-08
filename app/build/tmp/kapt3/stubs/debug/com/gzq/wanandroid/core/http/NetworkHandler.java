package com.gzq.wanandroid.core.http;

import java.lang.System;

/**
 * Injectable class which returns information about the network connection state.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/gzq/wanandroid/core/http/NetworkHandler;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isNetworkAvailable", "", "app_debug"})
public final class NetworkHandler {
    private final android.content.Context context = null;
    
    public NetworkHandler(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    /**
     * 检查当前网络是否可用
     */
    public final boolean isNetworkAvailable() {
        return false;
    }
}