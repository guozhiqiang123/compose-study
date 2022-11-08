package com.gzq.wanandroid.widget;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u001c\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/gzq/wanandroid/widget/CustomWebViewClient;", "Lcom/just/agentweb/WebViewClient;", "onEvent", "Lkotlin/Function1;", "Lcom/gzq/wanandroid/widget/WebViewEvent;", "", "(Lkotlin/jvm/functions/Function1;)V", "onPageFinished", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "request", "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "app_debug"})
public final class CustomWebViewClient extends com.just.agentweb.WebViewClient {
    private final kotlin.jvm.functions.Function1<com.gzq.wanandroid.widget.WebViewEvent, kotlin.Unit> onEvent = null;
    
    public CustomWebViewClient() {
        super();
    }
    
    public CustomWebViewClient(@org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function1<? super com.gzq.wanandroid.widget.WebViewEvent, kotlin.Unit> onEvent) {
        super();
    }
    
    @java.lang.Override
    public void onPageStarted(@org.jetbrains.annotations.Nullable
    android.webkit.WebView view, @org.jetbrains.annotations.Nullable
    java.lang.String url, @org.jetbrains.annotations.Nullable
    android.graphics.Bitmap favicon) {
    }
    
    @java.lang.Override
    public void onPageFinished(@org.jetbrains.annotations.Nullable
    android.webkit.WebView view, @org.jetbrains.annotations.Nullable
    java.lang.String url) {
    }
    
    @java.lang.Override
    public void onReceivedError(@org.jetbrains.annotations.Nullable
    android.webkit.WebView view, @org.jetbrains.annotations.Nullable
    android.webkit.WebResourceRequest request, @org.jetbrains.annotations.Nullable
    android.webkit.WebResourceError error) {
    }
}