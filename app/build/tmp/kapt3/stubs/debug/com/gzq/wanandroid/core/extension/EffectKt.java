package com.gzq.wanandroid.core.extension;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ay\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2/\u0010\n\u001a+\b\u0001\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b\u00a2\u0006\u0002\b\u000eH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"DisposableRepeatEffect", "", "T", "key1", "Landroidx/lifecycle/LiveData;", "keys", "", "", "reset", "", "block", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/lifecycle/LiveData;[Ljava/lang/Object;ZLkotlin/jvm/functions/Function3;)V", "app_debug"})
public final class EffectKt {
    
    /**
     * 一些错误逻辑，比如登录时候，密码错误，多次调用登录接口，应该都能弹出错误提示。
     * 也就是各种监听不应该被防抖。
     * 所以针对这种情况，单独封装了这个Effect。该Effect只能配合LiveData使用，如果需要配合Flow使用，请自行封装。
     * @param key1 必须是LiveData
     * @param keys 其他key
     * @param reset 是否在生命周期结束的时候重置LiveData的值
     * @param block 协程体
     */
    @androidx.compose.runtime.Composable
    public static final <T extends java.lang.Object>void DisposableRepeatEffect(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.LiveData<T> key1, @org.jetbrains.annotations.NotNull
    java.lang.Object[] keys, boolean reset, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function3<? super kotlinx.coroutines.CoroutineScope, ? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> block) {
    }
}