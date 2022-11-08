package com.zlcoder.core.extension;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b\u001a\n\u0010\t\u001a\u00020\n*\u00020\u0002\u001a\n\u0010\u000b\u001a\u00020\n*\u00020\u0002\u001a\n\u0010\f\u001a\u00020\n*\u00020\u0002\u001a\n\u0010\r\u001a\u00020\n*\u00020\u0002\u001a\u0016\u0010\u000e\u001a\u00020\u0006*\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0011"}, d2 = {"connectivityManager", "Landroid/net/ConnectivityManager;", "Landroid/content/Context;", "getConnectivityManager", "(Landroid/content/Context;)Landroid/net/ConnectivityManager;", "copyToClipboard", "", "text", "", "isAppNightMode", "", "isScreenLandscape", "isSystemNightMode", "launchWeChat", "toast", "any", "", "app_debug"})
public final class ContextKt {
    
    @org.jetbrains.annotations.NotNull
    public static final android.net.ConnectivityManager getConnectivityManager(@org.jetbrains.annotations.NotNull
    android.content.Context $this$connectivityManager) {
        return null;
    }
    
    /**
     * 启动微信
     */
    public static final boolean launchWeChat(@org.jetbrains.annotations.NotNull
    android.content.Context $this$launchWeChat) {
        return false;
    }
    
    /**
     * 将内容复制到剪贴板
     */
    public static final void copyToClipboard(@org.jetbrains.annotations.NotNull
    android.content.Context $this$copyToClipboard, @org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
    
    /**
     * 当前APP是不是暗黑模式
     */
    public static final boolean isAppNightMode(@org.jetbrains.annotations.NotNull
    android.content.Context $this$isAppNightMode) {
        return false;
    }
    
    /**
     * 系统是否是暗黑模式
     */
    public static final boolean isSystemNightMode(@org.jetbrains.annotations.NotNull
    android.content.Context $this$isSystemNightMode) {
        return false;
    }
    
    /**
     * 屏幕是否是横屏
     */
    public static final boolean isScreenLandscape(@org.jetbrains.annotations.NotNull
    android.content.Context $this$isScreenLandscape) {
        return false;
    }
    
    /**
     * toast
     * @param any object
     */
    public static final void toast(@org.jetbrains.annotations.NotNull
    android.content.Context $this$toast, @org.jetbrains.annotations.Nullable
    java.lang.Object any) {
    }
}