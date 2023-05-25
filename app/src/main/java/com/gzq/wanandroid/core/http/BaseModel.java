package com.gzq.wanandroid.core.http;

import androidx.annotation.Keep;

/**
 * 接口数据基本Model
 * @param <T>
 */
@Keep
public interface BaseModel<T> {
    boolean isSuccess();

    int getCode();

    String getMessage();

    T getData();
}
