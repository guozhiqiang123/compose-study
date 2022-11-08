package com.gzq.wanandroid.router;

import java.lang.System;

/**
 * 如果需要传参，请参照DetailPage，单独提供方法，统一传参，方便维护
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\n\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\n\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u00a8\u0006\u001b"}, d2 = {"Lcom/gzq/wanandroid/router/Router;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "CoilImagePage", "DetailPage", "FreeStylePage", "GlideImagePage", "HomePage", "LoginPage", "ProfilePage", "ProjectPage", "RegisterPage", "SketchImagePage", "Lcom/gzq/wanandroid/router/Router$CoilImagePage;", "Lcom/gzq/wanandroid/router/Router$DetailPage;", "Lcom/gzq/wanandroid/router/Router$FreeStylePage;", "Lcom/gzq/wanandroid/router/Router$GlideImagePage;", "Lcom/gzq/wanandroid/router/Router$HomePage;", "Lcom/gzq/wanandroid/router/Router$LoginPage;", "Lcom/gzq/wanandroid/router/Router$ProfilePage;", "Lcom/gzq/wanandroid/router/Router$ProjectPage;", "Lcom/gzq/wanandroid/router/Router$RegisterPage;", "Lcom/gzq/wanandroid/router/Router$SketchImagePage;", "app_debug"})
public abstract class Router {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String route = null;
    
    private Router(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/gzq/wanandroid/router/Router$HomePage;", "Lcom/gzq/wanandroid/router/Router;", "()V", "app_debug"})
    public static final class HomePage extends com.gzq.wanandroid.router.Router {
        @org.jetbrains.annotations.NotNull
        public static final com.gzq.wanandroid.router.Router.HomePage INSTANCE = null;
        
        private HomePage() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/gzq/wanandroid/router/Router$ProjectPage;", "Lcom/gzq/wanandroid/router/Router;", "()V", "app_debug"})
    public static final class ProjectPage extends com.gzq.wanandroid.router.Router {
        @org.jetbrains.annotations.NotNull
        public static final com.gzq.wanandroid.router.Router.ProjectPage INSTANCE = null;
        
        private ProjectPage() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/gzq/wanandroid/router/Router$ProfilePage;", "Lcom/gzq/wanandroid/router/Router;", "()V", "app_debug"})
    public static final class ProfilePage extends com.gzq.wanandroid.router.Router {
        @org.jetbrains.annotations.NotNull
        public static final com.gzq.wanandroid.router.Router.ProfilePage INSTANCE = null;
        
        private ProfilePage() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/gzq/wanandroid/router/Router$GlideImagePage;", "Lcom/gzq/wanandroid/router/Router;", "()V", "app_debug"})
    public static final class GlideImagePage extends com.gzq.wanandroid.router.Router {
        @org.jetbrains.annotations.NotNull
        public static final com.gzq.wanandroid.router.Router.GlideImagePage INSTANCE = null;
        
        private GlideImagePage() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/gzq/wanandroid/router/Router$CoilImagePage;", "Lcom/gzq/wanandroid/router/Router;", "()V", "app_debug"})
    public static final class CoilImagePage extends com.gzq.wanandroid.router.Router {
        @org.jetbrains.annotations.NotNull
        public static final com.gzq.wanandroid.router.Router.CoilImagePage INSTANCE = null;
        
        private CoilImagePage() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/gzq/wanandroid/router/Router$SketchImagePage;", "Lcom/gzq/wanandroid/router/Router;", "()V", "app_debug"})
    public static final class SketchImagePage extends com.gzq.wanandroid.router.Router {
        @org.jetbrains.annotations.NotNull
        public static final com.gzq.wanandroid.router.Router.SketchImagePage INSTANCE = null;
        
        private SketchImagePage() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/gzq/wanandroid/router/Router$DetailPage;", "Lcom/gzq/wanandroid/router/Router;", "()V", "createRoute", "", "url", "app_debug"})
    public static final class DetailPage extends com.gzq.wanandroid.router.Router {
        @org.jetbrains.annotations.NotNull
        public static final com.gzq.wanandroid.router.Router.DetailPage INSTANCE = null;
        
        private DetailPage() {
            super(null);
        }
        
        /**
         * 必须提供跳转链接
         * 因为网页链接不能作为DeepLink的必传参数，否则会报错，所以使用可传参数
         *
         * @param url 网页链接
         */
        @org.jetbrains.annotations.NotNull
        public final java.lang.String createRoute(@org.jetbrains.annotations.NotNull
        java.lang.String url) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/gzq/wanandroid/router/Router$LoginPage;", "Lcom/gzq/wanandroid/router/Router;", "()V", "app_debug"})
    public static final class LoginPage extends com.gzq.wanandroid.router.Router {
        @org.jetbrains.annotations.NotNull
        public static final com.gzq.wanandroid.router.Router.LoginPage INSTANCE = null;
        
        private LoginPage() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/gzq/wanandroid/router/Router$RegisterPage;", "Lcom/gzq/wanandroid/router/Router;", "()V", "app_debug"})
    public static final class RegisterPage extends com.gzq.wanandroid.router.Router {
        @org.jetbrains.annotations.NotNull
        public static final com.gzq.wanandroid.router.Router.RegisterPage INSTANCE = null;
        
        private RegisterPage() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/gzq/wanandroid/router/Router$FreeStylePage;", "Lcom/gzq/wanandroid/router/Router;", "()V", "app_debug"})
    public static final class FreeStylePage extends com.gzq.wanandroid.router.Router {
        @org.jetbrains.annotations.NotNull
        public static final com.gzq.wanandroid.router.Router.FreeStylePage INSTANCE = null;
        
        private FreeStylePage() {
            super(null);
        }
    }
}