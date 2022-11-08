package com.gzq.wanandroid.core.glide;

import java.lang.System;

/**
 * 自定义全局Glide实例，请使用GlideApp.with()代替Glide.with()
 */
@com.bumptech.glide.annotation.GlideModule
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/gzq/wanandroid/core/glide/WanandroidGlideModule;", "Lcom/bumptech/glide/module/AppGlideModule;", "()V", "isManifestParsingEnabled", "", "app_debug"})
public final class WanandroidGlideModule extends com.bumptech.glide.module.AppGlideModule {
    
    public WanandroidGlideModule() {
        super();
    }
    
    @java.lang.Override
    public boolean isManifestParsingEnabled() {
        return false;
    }
}