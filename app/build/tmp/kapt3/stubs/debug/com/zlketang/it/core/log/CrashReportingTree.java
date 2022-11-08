package com.zlketang.it.core.log;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0005\u00a2\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014\u00a8\u0006\r"}, d2 = {"Lcom/zlketang/it/core/log/CrashReportingTree;", "Ltimber/log/Timber$Tree;", "()V", "log", "", "priority", "", "tag", "", "message", "t", "", "FakeCrashLibrary", "app_debug"})
public final class CrashReportingTree extends timber.log.Timber.Tree {
    
    public CrashReportingTree() {
        super();
    }
    
    @java.lang.Override
    protected void log(int priority, @org.jetbrains.annotations.Nullable
    java.lang.String tag, @org.jetbrains.annotations.NotNull
    java.lang.String message, @org.jetbrains.annotations.Nullable
    java.lang.Throwable t) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/zlketang/it/core/log/CrashReportingTree$FakeCrashLibrary;", "", "()V", "Companion", "app_debug"})
    public static final class FakeCrashLibrary {
        @org.jetbrains.annotations.NotNull
        public static final com.zlketang.it.core.log.CrashReportingTree.FakeCrashLibrary.Companion Companion = null;
        
        private FakeCrashLibrary() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r\u00a8\u0006\u000f"}, d2 = {"Lcom/zlketang/it/core/log/CrashReportingTree$FakeCrashLibrary$Companion;", "", "()V", "log", "", "priority", "", "tag", "", "message", "logError", "msg", "t", "", "logWarning", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
            
            public final void log(int priority, @org.jetbrains.annotations.Nullable
            java.lang.String tag, @org.jetbrains.annotations.Nullable
            java.lang.String message) {
            }
            
            public final void logWarning(@org.jetbrains.annotations.Nullable
            java.lang.Throwable t) {
            }
            
            public final void logError(@org.jetbrains.annotations.Nullable
            java.lang.String msg, @org.jetbrains.annotations.Nullable
            java.lang.Throwable t) {
            }
        }
    }
}