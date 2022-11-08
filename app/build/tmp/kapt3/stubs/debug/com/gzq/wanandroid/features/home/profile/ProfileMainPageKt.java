package com.gzq.wanandroid.features.home.profile;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010(\u001a\u00020)H\u0007\u001a\b\u0010*\u001a\u00020)H\u0007\u001a$\u0010+\u001a\u00020)2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020)0-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020)0-H\u0007\u001a:\u0010/\u001a\u00020)2\u0006\u00100\u001a\u0002012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020)0-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020)0-2\f\u00102\u001a\b\u0012\u0004\u0012\u00020)0-H\u0007\u001a\b\u00103\u001a\u00020)H\u0007\u001a\u0016\u00104\u001a\u00020)2\f\u00102\u001a\b\u0012\u0004\u0012\u00020)0-H\u0007\u001a\b\u00105\u001a\u00020)H\u0007\u001aD\u00106\u001a\u00020)2\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020:2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020)0-2\u0018\u0010<\u001a\u0014\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020)0=H\u0007\u001a\u001c\u0010?\u001a\u00020)*\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020BH\u0007\u001a\f\u0010D\u001a\u00020)*\u00020EH\u0007\u001a@\u0010F\u001a\u00020)*\u00020G2\u0006\u0010H\u001a\u00020I2\u0018\u0010<\u001a\u0014\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020)0=2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020)0K\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0080\u0004\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0019\u0010\u0005\u001a\u00020\u0001X\u0080\u0004\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0019\u0010\u0007\u001a\u00020\u0001X\u0080\u0004\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\b\u0010\u0003\"\u0019\u0010\t\u001a\u00020\u0001X\u0080\u0004\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\n\u0010\u0003\"\u0019\u0010\u000b\u001a\u00020\u0001X\u0080\u0004\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\f\u0010\u0003\"\u0019\u0010\r\u001a\u00020\u0001X\u0080\u0004\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u000e\u0010\u0003\"\u0019\u0010\u000f\u001a\u00020\u0001X\u0080\u0004\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\u0003\"\u0019\u0010\u0011\u001a\u00020\u0012X\u0080\u0004\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014\"\u0019\u0010\u0016\u001a\u00020\u0012X\u0080\u0004\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014\"\u0019\u0010\u0018\u001a\u00020\u0001X\u0080\u0004\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0019\u0010\u0003\"\u0019\u0010\u001a\u001a\u00020\u0001X\u0080\u0004\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u001b\u0010\u0003\"\u0019\u0010\u001c\u001a\u00020\u0001X\u0080\u0004\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u001d\u0010\u0003\"\u0019\u0010\u001e\u001a\u00020\u0001X\u0080\u0004\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u001f\u0010\u0003\"\u0019\u0010 \u001a\u00020\u0012X\u0080\u0004\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b!\u0010\u0014\"\u0019\u0010\"\u001a\u00020\u0001X\u0080\u0004\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b#\u0010\u0003\"\u0019\u0010$\u001a\u00020\u0001X\u0080\u0004\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b%\u0010\u0003\"\u0019\u0010&\u001a\u00020\u0012X\u0080\u0004\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\'\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006L"}, d2 = {"CollapsedAppBarHeight", "Landroidx/compose/ui/unit/Dp;", "getCollapsedAppBarHeight", "()F", "F", "CollapsedImageOffsetX", "getCollapsedImageOffsetX", "CollapsedImageOffsetY", "getCollapsedImageOffsetY", "CollapsedImageSize", "getCollapsedImageSize", "CollapsedOffsetY", "getCollapsedOffsetY", "CollapsedTextOffsetX", "getCollapsedTextOffsetX", "CollapsedTextOffsetY", "getCollapsedTextOffsetY", "CollapsedTextSize", "Landroidx/compose/ui/unit/TextUnit;", "getCollapsedTextSize", "()J", "J", "CollapsedTextSizeLineHeight", "getCollapsedTextSizeLineHeight", "ExpandedAppBarHeight", "getExpandedAppBarHeight", "ExpandedImageOffsetX", "getExpandedImageOffsetX", "ExpandedImageOffsetY", "getExpandedImageOffsetY", "ExpandedImageSize", "getExpandedImageSize", "ExpandedTextLineHeight", "getExpandedTextLineHeight", "ExpandedTextOffsetX", "getExpandedTextOffsetX", "ExpandedTextOffsetY", "getExpandedTextOffsetY", "ExpandedTextSize", "getExpandedTextSize", "BaseUserInfo", "", "GradientHeader", "MenuAccount", "exitLogin", "Lkotlin/Function0;", "checkUpdate", "MenuList", "scroll", "Landroidx/compose/foundation/ScrollState;", "showOnDevelop", "MenuNormal", "MenuSetup", "PreviewProfileMainPage", "ProfileMainPage", "modifier", "Landroidx/compose/ui/Modifier;", "viewModel", "Lcom/gzq/wanandroid/features/home/profile/ProfileMainViewModel;", "launchLoginPage", "loginController", "Lkotlin/Function2;", "", "BaseUserInfoItem", "Landroidx/compose/foundation/layout/RowScope;", "label", "", "value", "Notification", "Landroidx/compose/foundation/layout/BoxScope;", "profileMainPage", "Landroidx/navigation/NavGraphBuilder;", "navController", "Landroidx/navigation/NavHostController;", "showBottomNavigationBar", "Lkotlin/Function1;", "app_debug"})
public final class ProfileMainPageKt {
    private static final float CollapsedAppBarHeight = 0.0F;
    private static final float ExpandedAppBarHeight = 0.0F;
    private static final float ExpandedImageSize = 0.0F;
    private static final float CollapsedImageSize = 0.0F;
    private static final float ExpandedImageOffsetY = 0.0F;
    private static final float CollapsedImageOffsetY = 0.0F;
    private static final float ExpandedImageOffsetX = 0.0F;
    private static final float CollapsedImageOffsetX = 0.0F;
    private static final float CollapsedOffsetY = 0.0F;
    private static final long ExpandedTextLineHeight = 0L;
    private static final long CollapsedTextSizeLineHeight = 0L;
    private static final long ExpandedTextSize = 0L;
    private static final long CollapsedTextSize = 0L;
    private static final float ExpandedTextOffsetX = 0.0F;
    private static final float CollapsedTextOffsetX = 0.0F;
    private static final float ExpandedTextOffsetY = 0.0F;
    private static final float CollapsedTextOffsetY = 0.0F;
    
    public static final float getCollapsedAppBarHeight() {
        return 0.0F;
    }
    
    public static final float getExpandedAppBarHeight() {
        return 0.0F;
    }
    
    public static final float getExpandedImageSize() {
        return 0.0F;
    }
    
    public static final float getCollapsedImageSize() {
        return 0.0F;
    }
    
    public static final float getExpandedImageOffsetY() {
        return 0.0F;
    }
    
    public static final float getCollapsedImageOffsetY() {
        return 0.0F;
    }
    
    public static final float getExpandedImageOffsetX() {
        return 0.0F;
    }
    
    public static final float getCollapsedImageOffsetX() {
        return 0.0F;
    }
    
    public static final float getCollapsedOffsetY() {
        return 0.0F;
    }
    
    public static final long getExpandedTextLineHeight() {
        return 0L;
    }
    
    public static final long getCollapsedTextSizeLineHeight() {
        return 0L;
    }
    
    public static final long getExpandedTextSize() {
        return 0L;
    }
    
    public static final long getCollapsedTextSize() {
        return 0L;
    }
    
    public static final float getExpandedTextOffsetX() {
        return 0.0F;
    }
    
    public static final float getCollapsedTextOffsetX() {
        return 0.0F;
    }
    
    public static final float getExpandedTextOffsetY() {
        return 0.0F;
    }
    
    public static final float getCollapsedTextOffsetY() {
        return 0.0F;
    }
    
    public static final void profileMainPage(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavGraphBuilder $this$profileMainPage, @org.jetbrains.annotations.NotNull
    androidx.navigation.NavHostController navController, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.Boolean, kotlin.Unit> loginController, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> showBottomNavigationBar) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ProfileMainPage(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.gzq.wanandroid.features.home.profile.ProfileMainViewModel viewModel, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> launchLoginPage, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.Boolean, kotlin.Unit> loginController) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void Notification(@org.jetbrains.annotations.NotNull
    androidx.compose.foundation.layout.BoxScope $this$Notification) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void GradientHeader() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void BaseUserInfo() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void BaseUserInfoItem(@org.jetbrains.annotations.NotNull
    androidx.compose.foundation.layout.RowScope $this$BaseUserInfoItem, @org.jetbrains.annotations.NotNull
    java.lang.String label, @org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void MenuList(@org.jetbrains.annotations.NotNull
    androidx.compose.foundation.ScrollState scroll, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> exitLogin, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> checkUpdate, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> showOnDevelop) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void MenuNormal() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void MenuSetup(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> showOnDevelop) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void MenuAccount(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> exitLogin, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> checkUpdate) {
    }
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview
    public static final void PreviewProfileMainPage() {
    }
}