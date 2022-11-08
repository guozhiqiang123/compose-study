package com.gzq.wanandroid.core.page;

import java.lang.System;

/**
 * 描述页面状态
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0005\u0004\u0005\u0006\u0007\bB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r\u00a8\u0006\u000e"}, d2 = {"Lcom/gzq/wanandroid/core/page/PageState;", "T", "", "()V", "ComingSoon", "Empty", "Error", "Loading", "Success", "Lcom/gzq/wanandroid/core/page/PageState$ComingSoon;", "Lcom/gzq/wanandroid/core/page/PageState$Empty;", "Lcom/gzq/wanandroid/core/page/PageState$Error;", "Lcom/gzq/wanandroid/core/page/PageState$Loading;", "Lcom/gzq/wanandroid/core/page/PageState$Success;", "app_debug"})
public abstract class PageState<T extends java.lang.Object> {
    
    private PageState() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00018\u0001H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0006J \u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0001H\u00c6\u0001\u00a2\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"Lcom/gzq/wanandroid/core/page/PageState$Success;", "T", "Lcom/gzq/wanandroid/core/page/PageState;", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/gzq/wanandroid/core/page/PageState$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class Success<T extends java.lang.Object> extends com.gzq.wanandroid.core.page.PageState<T> {
        @org.jetbrains.annotations.Nullable
        private final T data = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.gzq.wanandroid.core.page.PageState.Success<T> copy(@org.jetbrains.annotations.Nullable
        T data) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public Success() {
            super();
        }
        
        public Success(@org.jetbrains.annotations.Nullable
        T data) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final T component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final T getData() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/gzq/wanandroid/core/page/PageState$Error;", "Lcom/gzq/wanandroid/core/page/PageState;", "", "throwable", "", "value", "", "(Ljava/lang/Throwable;Ljava/lang/Object;)V", "getThrowable", "()Ljava/lang/Throwable;", "getValue", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class Error extends com.gzq.wanandroid.core.page.PageState {
        @org.jetbrains.annotations.Nullable
        private final java.lang.Throwable throwable = null;
        @org.jetbrains.annotations.Nullable
        private final java.lang.Object value = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.gzq.wanandroid.core.page.PageState.Error copy(@org.jetbrains.annotations.Nullable
        java.lang.Throwable throwable, @org.jetbrains.annotations.Nullable
        java.lang.Object value) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public Error() {
            super();
        }
        
        public Error(@org.jetbrains.annotations.Nullable
        java.lang.Throwable throwable, @org.jetbrains.annotations.Nullable
        java.lang.Object value) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Throwable component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Throwable getThrowable() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object getValue() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/gzq/wanandroid/core/page/PageState$Loading;", "Lcom/gzq/wanandroid/core/page/PageState;", "", "()V", "app_debug"})
    public static final class Loading extends com.gzq.wanandroid.core.page.PageState {
        @org.jetbrains.annotations.NotNull
        public static final com.gzq.wanandroid.core.page.PageState.Loading INSTANCE = null;
        
        private Loading() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/gzq/wanandroid/core/page/PageState$Empty;", "Lcom/gzq/wanandroid/core/page/PageState;", "", "value", "", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class Empty extends com.gzq.wanandroid.core.page.PageState {
        @org.jetbrains.annotations.Nullable
        private final java.lang.Object value = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.gzq.wanandroid.core.page.PageState.Empty copy(@org.jetbrains.annotations.Nullable
        java.lang.Object value) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public Empty() {
            super();
        }
        
        public Empty(@org.jetbrains.annotations.Nullable
        java.lang.Object value) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object getValue() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/gzq/wanandroid/core/page/PageState$ComingSoon;", "Lcom/gzq/wanandroid/core/page/PageState;", "", "()V", "app_debug"})
    public static final class ComingSoon extends com.gzq.wanandroid.core.page.PageState {
        @org.jetbrains.annotations.NotNull
        public static final com.gzq.wanandroid.core.page.PageState.ComingSoon INSTANCE = null;
        
        private ComingSoon() {
            super();
        }
    }
}