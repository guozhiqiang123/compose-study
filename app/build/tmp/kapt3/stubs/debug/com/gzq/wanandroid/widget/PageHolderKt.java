package com.gzq.wanandroid.widget;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\b\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\b\u0010\u0003\u001a\u00020\u0001H\u0007\u001a\u00c1\u0001\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u001e\b\u0002\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b\u00a2\u0006\u0002\b\r\u00a2\u0006\u0002\b\u000e2\u001e\b\u0002\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b\u00a2\u0006\u0002\b\r\u00a2\u0006\u0002\b\u000e2\u001e\b\u0002\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b\u00a2\u0006\u0002\b\r\u00a2\u0006\u0002\b\u000e2\u001e\b\u0002\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b\u00a2\u0006\u0002\b\r\u00a2\u0006\u0002\b\u000e2\u0019\u0010\u0012\u001a\u0015\u0012\u0006\u0012\u0004\u0018\u0001H\u0005\u0012\u0004\u0012\u00020\u00010\u000b\u00a2\u0006\u0002\b\rH\u0007\u001a\b\u0010\u0013\u001a\u00020\u0001H\u0007\u00a8\u0006\u0014"}, d2 = {"EmptyPreView", "", "ErrorPreView", "LoadingPreView", "PageHolder", "T", "pageState", "Lcom/gzq/wanandroid/core/page/PageState;", "modifier", "Landroidx/compose/ui/Modifier;", "loadingComponentBlock", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "emptyComponentBlock", "errorComponentBlock", "comingSoonComponentBlock", "content", "SuccessPreView", "app_debug"})
public final class PageHolderKt {
    
    /**
     * 状态页面
     */
    @androidx.compose.runtime.Composable
    public static final <T extends java.lang.Object>void PageHolder(@org.jetbrains.annotations.NotNull
    com.gzq.wanandroid.core.page.PageState<? extends T> pageState, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super androidx.compose.foundation.layout.BoxScope, kotlin.Unit> loadingComponentBlock, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super androidx.compose.foundation.layout.BoxScope, kotlin.Unit> emptyComponentBlock, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super androidx.compose.foundation.layout.BoxScope, kotlin.Unit> errorComponentBlock, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super androidx.compose.foundation.layout.BoxScope, kotlin.Unit> comingSoonComponentBlock, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> content) {
    }
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    public static final void LoadingPreView() {
    }
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    public static final void SuccessPreView() {
    }
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    public static final void ErrorPreView() {
    }
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    public static final void EmptyPreView() {
    }
}