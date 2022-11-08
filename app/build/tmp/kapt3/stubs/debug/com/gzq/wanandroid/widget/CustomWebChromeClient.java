package com.gzq.wanandroid.widget;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006J\u001a\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001c\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/gzq/wanandroid/widget/CustomWebChromeClient;", "Lcom/just/agentweb/WebChromeClient;", "onEvent", "Lkotlin/Function1;", "Lcom/gzq/wanandroid/widget/WebViewEvent;", "", "(Lkotlin/jvm/functions/Function1;)V", "onProgressChanged", "view", "Landroid/webkit/WebView;", "newProgress", "", "onReceivedTitle", "title", "", "app_debug"})
public final class CustomWebChromeClient extends com.just.agentweb.WebChromeClient {
    private final kotlin.jvm.functions.Function1<com.gzq.wanandroid.widget.WebViewEvent, kotlin.Unit> onEvent = null;
    
    public CustomWebChromeClient() {
        super();
    }
    
    public CustomWebChromeClient(@org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function1<? super com.gzq.wanandroid.widget.WebViewEvent, kotlin.Unit> onEvent) {
        super();
    }
    
    @java.lang.Override
    public void onReceivedTitle(@org.jetbrains.annotations.Nullable
    android.webkit.WebView view, @org.jetbrains.annotations.Nullable
    java.lang.String title) {
    }
    
    @java.lang.Override
    public void onProgressChanged(@org.jetbrains.annotations.Nullable
    android.webkit.WebView view, int newProgress) {
    }
}