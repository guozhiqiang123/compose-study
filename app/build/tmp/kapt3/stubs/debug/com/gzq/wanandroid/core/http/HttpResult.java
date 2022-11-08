package com.gzq.wanandroid.core.http;

import java.lang.System;

/**
 * 默认HttpResult,如果格式和此处有较大差异，可implements BaseModel进行扩展
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u000f\u0010\f\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u0010\rJ\n\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0010\u0010\u0005\u001a\u00020\u00068\u0002X\u0083D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00018\u00008\u0002X\u0083\u0004\u00a2\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\t\u001a\u0004\u0018\u00010\n8\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/gzq/wanandroid/core/http/HttpResult;", "T", "Lcom/gzq/wanandroid/core/http/BaseModel;", "Ljava/io/Serializable;", "()V", "code", "", "data", "Ljava/lang/Object;", "message", "", "getCode", "getData", "()Ljava/lang/Object;", "getMessage", "isSuccess", "", "app_debug"})
public final class HttpResult<T extends java.lang.Object> implements com.gzq.wanandroid.core.http.BaseModel<T>, java.io.Serializable {
    @com.google.gson.annotations.SerializedName(value = "errorCode")
    private final int code = -1;
    @com.google.gson.annotations.SerializedName(value = "errorMsg")
    private final java.lang.String message = null;
    @com.google.gson.annotations.SerializedName(value = "data", alternate = {"subjects", "result", "error"})
    private final T data = null;
    
    public HttpResult() {
        super();
    }
    
    @java.lang.Override
    public boolean isSuccess() {
        return false;
    }
    
    @java.lang.Override
    public int getCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.String getMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public T getData() {
        return null;
    }
}