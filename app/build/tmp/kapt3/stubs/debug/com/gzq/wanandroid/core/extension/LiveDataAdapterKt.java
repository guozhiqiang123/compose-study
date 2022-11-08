package com.gzq.wanandroid.core.extension;

import java.lang.System;

@kotlin.Suppress(names = {"UNCHECKED_CAST"})
@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a \u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a5\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0004\"\b\b\u0001\u0010\u0002*\u0002H\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0005\u001a\u0002H\u0004H\u0003\u00a2\u0006\u0002\u0010\u0006\u001a \u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u00a8\u0006\b"}, d2 = {"observeAutoResetAsState", "Landroidx/compose/runtime/State;", "T", "Landroidx/lifecycle/LiveData;", "R", "initial", "(Landroidx/lifecycle/LiveData;Ljava/lang/Object;)Landroidx/compose/runtime/State;", "observeUniqueOnlyState", "app_debug"})
public final class LiveDataAdapterKt {
    
    /**
     * livedata防抖
     */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    public static final <T extends java.lang.Object>androidx.compose.runtime.State<T> observeUniqueOnlyState(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.LiveData<T> $this$observeUniqueOnlyState) {
        return null;
    }
    
    /**
     * 该方式目前能解决[Composable]中，[LiveData]数据倒灌的问题。
     * 注意：该方式不是很优雅，后面我学习到更加优秀的方案，再来替换。
     */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    public static final <T extends java.lang.Object>androidx.compose.runtime.State<T> observeAutoResetAsState(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.LiveData<T> $this$observeAutoResetAsState) {
        return null;
    }
    
    /**
     * 为了解决使用[LaunchedEffect]等副作用，在屏幕旋转、页面重新进入前台等情况下，出现观察[LiveData]数据倒灌的问题。
     * 注意：该方式不是很优雅，后面我学习到更加优秀的方案，再来替换。
     * 在onDispose中直接把LiveData的值再次设置为初始值。
     */
    @androidx.compose.runtime.Composable
    private static final <R extends java.lang.Object, T extends R>androidx.compose.runtime.State<R> observeAutoResetAsState(androidx.lifecycle.LiveData<T> $this$observeAutoResetAsState, R initial) {
        return null;
    }
}