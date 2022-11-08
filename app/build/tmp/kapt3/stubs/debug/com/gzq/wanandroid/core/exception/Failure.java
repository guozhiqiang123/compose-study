package com.gzq.wanandroid.core.exception;

import java.lang.System;

/**
 * 自定义错误
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lcom/gzq/wanandroid/core/exception/Failure;", "", "()V", "EmptyData", "NetworkError", "None", "OtherError", "ServerError", "Lcom/gzq/wanandroid/core/exception/Failure$EmptyData;", "Lcom/gzq/wanandroid/core/exception/Failure$NetworkError;", "Lcom/gzq/wanandroid/core/exception/Failure$None;", "Lcom/gzq/wanandroid/core/exception/Failure$OtherError;", "Lcom/gzq/wanandroid/core/exception/Failure$ServerError;", "app_debug"})
public abstract class Failure extends java.lang.Throwable {
    
    private Failure() {
        super(null);
    }
    
    /**
     * 主要给State设置初始状态
     */
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/gzq/wanandroid/core/exception/Failure$None;", "Lcom/gzq/wanandroid/core/exception/Failure;", "()V", "app_debug"})
    public static final class None extends com.gzq.wanandroid.core.exception.Failure {
        @org.jetbrains.annotations.NotNull
        public static final com.gzq.wanandroid.core.exception.Failure.None INSTANCE = null;
        
        private None() {
            super();
        }
    }
    
    /**
     * 网络错误
     */
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/gzq/wanandroid/core/exception/Failure$NetworkError;", "Lcom/gzq/wanandroid/core/exception/Failure;", "()V", "app_debug"})
    public static final class NetworkError extends com.gzq.wanandroid.core.exception.Failure {
        @org.jetbrains.annotations.NotNull
        public static final com.gzq.wanandroid.core.exception.Failure.NetworkError INSTANCE = null;
        
        private NetworkError() {
            super();
        }
    }
    
    /**
     * 服务器返回的业务错误
     */
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/gzq/wanandroid/core/exception/Failure$ServerError;", "Lcom/gzq/wanandroid/core/exception/Failure;", "code", "", "msg", "", "(ILjava/lang/String;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "app_debug"})
    public static final class ServerError extends com.gzq.wanandroid.core.exception.Failure {
        private final int code = 0;
        @org.jetbrains.annotations.Nullable
        private final java.lang.String msg = null;
        
        /**
         * 服务器返回的业务错误
         */
        @org.jetbrains.annotations.NotNull
        public final com.gzq.wanandroid.core.exception.Failure.ServerError copy(int code, @org.jetbrains.annotations.Nullable
        java.lang.String msg) {
            return null;
        }
        
        /**
         * 服务器返回的业务错误
         */
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        /**
         * 服务器返回的业务错误
         */
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        /**
         * 服务器返回的业务错误
         */
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public ServerError() {
            super();
        }
        
        public ServerError(int code, @org.jetbrains.annotations.Nullable
        java.lang.String msg) {
            super();
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int getCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getMsg() {
            return null;
        }
    }
    
    /**
     * 例如数据处理过程中的错误，http协议错误
     */
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/gzq/wanandroid/core/exception/Failure$OtherError;", "Lcom/gzq/wanandroid/core/exception/Failure;", "throwable", "", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class OtherError extends com.gzq.wanandroid.core.exception.Failure {
        @org.jetbrains.annotations.Nullable
        private final java.lang.Throwable throwable = null;
        
        /**
         * 例如数据处理过程中的错误，http协议错误
         */
        @org.jetbrains.annotations.NotNull
        public final com.gzq.wanandroid.core.exception.Failure.OtherError copy(@org.jetbrains.annotations.Nullable
        java.lang.Throwable throwable) {
            return null;
        }
        
        /**
         * 例如数据处理过程中的错误，http协议错误
         */
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        /**
         * 例如数据处理过程中的错误，http协议错误
         */
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        /**
         * 例如数据处理过程中的错误，http协议错误
         */
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public OtherError() {
            super();
        }
        
        public OtherError(@org.jetbrains.annotations.Nullable
        java.lang.Throwable throwable) {
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
    }
    
    /**
     * 接口返回的data字段为空
     */
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/gzq/wanandroid/core/exception/Failure$EmptyData;", "Lcom/gzq/wanandroid/core/exception/Failure;", "()V", "app_debug"})
    public static final class EmptyData extends com.gzq.wanandroid.core.exception.Failure {
        @org.jetbrains.annotations.NotNull
        public static final com.gzq.wanandroid.core.exception.Failure.EmptyData INSTANCE = null;
        
        private EmptyData() {
            super();
        }
    }
}