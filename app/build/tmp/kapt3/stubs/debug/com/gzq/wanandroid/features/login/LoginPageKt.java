package com.gzq.wanandroid.features.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ap\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007\u001a$\u0010\u000e\u001a\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010H\u0007\u001a@\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001a\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u001a@\u0010\u001b\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\n\u00a8\u0006 "}, d2 = {"LoginPage", "", "loginController", "Lkotlin/Function2;", "", "viewModel", "Lcom/gzq/wanandroid/features/login/LoginViewModel;", "launchRegisterPage", "Lkotlin/Function0;", "launchPrivacyPage", "Lkotlin/Function1;", "", "launchUserPage", "clickBack", "NameAndPassword", "nameTextField", "Landroidx/compose/runtime/MutableState;", "pwdTextField", "PolicyText", "privacyUrl", "userUrl", "clickPrivacy", "clickUser", "parseSnackBarState", "Lcom/gzq/wanandroid/widget/SnackBarState;", "showInfo", "Lcom/gzq/wanandroid/features/login/LoginSnackInfo;", "loginPage", "Landroidx/navigation/NavGraphBuilder;", "navController", "Landroidx/navigation/NavHostController;", "showBottomNavigationBar", "app_debug"})
public final class LoginPageKt {
    
    public static final void loginPage(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavGraphBuilder $this$loginPage, @org.jetbrains.annotations.NotNull
    androidx.navigation.NavHostController navController, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.Boolean, kotlin.Unit> loginController, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> showBottomNavigationBar) {
    }
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    public static final void LoginPage(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.Boolean, kotlin.Unit> loginController, @org.jetbrains.annotations.NotNull
    com.gzq.wanandroid.features.login.LoginViewModel viewModel, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> launchRegisterPage, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> launchPrivacyPage, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> launchUserPage, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> clickBack) {
    }
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    public static final void NameAndPassword(@org.jetbrains.annotations.NotNull
    androidx.compose.runtime.MutableState<java.lang.String> nameTextField, @org.jetbrains.annotations.NotNull
    androidx.compose.runtime.MutableState<java.lang.String> pwdTextField) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void PolicyText(@org.jetbrains.annotations.NotNull
    java.lang.String privacyUrl, @org.jetbrains.annotations.NotNull
    java.lang.String userUrl, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> clickPrivacy, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> clickUser) {
    }
    
    @org.jetbrains.annotations.NotNull
    public static final com.gzq.wanandroid.widget.SnackBarState parseSnackBarState(@org.jetbrains.annotations.Nullable
    com.gzq.wanandroid.features.login.LoginSnackInfo showInfo) {
        return null;
    }
}