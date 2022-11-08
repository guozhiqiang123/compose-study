package com.gzq.wanandroid.widget;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u00aa\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\u0013\b\u0002\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00010\u0014\u00a2\u0006\u0002\b\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0019\u00a2\u0006\u0002\b\u001bH\u0007\u00a8\u0006\u001c"}, d2 = {"RefreshLoadMoreLazyColum", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Lcom/gzq/wanandroid/widget/RefreshLoadMoreState;", "listState", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "onRefreshCallBack", "Lkotlin/Function0;", "loadMoreCallBack", "loadMore", "Landroidx/compose/runtime/Composable;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "app_debug"})
public final class RefreshLoadMoreLazyColumKt {
    
    /**
     * 下拉刷新上拉加载控件
     * @param modifier Modifier
     * @param state RefreshLoadMoreState   控件状态，当设置为[RefreshLoadMoreState.Idle]时，则屏蔽加载更多
     * @param onRefreshCallBack Function0<Unit> 下拉刷新回调
     * @param loadMoreCallBack Function0<Unit>  加载更多回调
     * @param content [@kotlin.ExtensionFunctionType] Function1<LazyListScope, Unit>
     */
    @androidx.compose.runtime.Composable
    public static final void RefreshLoadMoreLazyColum(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.gzq.wanandroid.widget.RefreshLoadMoreState state, @org.jetbrains.annotations.NotNull
    androidx.compose.foundation.lazy.LazyListState listState, @org.jetbrains.annotations.NotNull
    androidx.compose.foundation.layout.PaddingValues contentPadding, boolean reverseLayout, @org.jetbrains.annotations.NotNull
    androidx.compose.foundation.layout.Arrangement.Vertical verticalArrangement, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Alignment.Horizontal horizontalAlignment, @org.jetbrains.annotations.NotNull
    androidx.compose.foundation.gestures.FlingBehavior flingBehavior, boolean userScrollEnabled, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onRefreshCallBack, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> loadMoreCallBack, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> loadMore, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> content) {
    }
}