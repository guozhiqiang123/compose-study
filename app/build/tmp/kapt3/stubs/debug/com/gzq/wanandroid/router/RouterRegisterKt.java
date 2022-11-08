package com.gzq.wanandroid.router;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aH\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a\n\u0010\u000b\u001a\u00020\u0006*\u00020\f\u00a8\u0006\r"}, d2 = {"RouterRegister", "", "navController", "Landroidx/navigation/NavHostController;", "loginController", "Lkotlin/Function2;", "", "showBottomNavigationBar", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "isHomePage", "Landroidx/navigation/NavBackStackEntry;", "app_debug"})
public final class RouterRegisterKt {
    
    @androidx.compose.runtime.Composable
    public static final void RouterRegister(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavHostController navController, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.Boolean, kotlin.Unit> loginController, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> showBottomNavigationBar, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * 判断是不是回到主页面
     */
    public static final boolean isHomePage(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavBackStackEntry $this$isHomePage) {
        return false;
    }
}