package com.gzq.wanandroid;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/gzq/wanandroid/App;", "Landroid/app/Application;", "Lcom/github/panpf/sketch/SketchFactory;", "()V", "attachBaseContext", "", "base", "Landroid/content/Context;", "createSketch", "Lcom/github/panpf/sketch/Sketch;", "onCreate", "app_debug"})
public final class App extends android.app.Application implements com.github.panpf.sketch.SketchFactory {
    
    public App() {
        super();
    }
    
    @java.lang.Override
    protected void attachBaseContext(@org.jetbrains.annotations.Nullable
    android.content.Context base) {
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    /**
     * Sketch支持图片加载，组件注册
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.github.panpf.sketch.Sketch createSketch() {
        return null;
    }
}