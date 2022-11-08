package com.gzq.wanandroid.features.home.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u0005J\u0018\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0006J\u000e\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u000eR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u000b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u000e0\u000e0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R#\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u000b0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014\u00a8\u0006%"}, d2 = {"Lcom/gzq/wanandroid/features/home/home/HomeMainViewModel;", "Lcom/gzq/wanandroid/core/base/BaseViewModel;", "()V", "_homeTab", "Landroidx/lifecycle/MutableLiveData;", "", "", "_listState", "Lcom/gzq/wanandroid/widget/RefreshLoadMoreState;", "kotlin.jvm.PlatformType", "_pageState", "Lcom/gzq/wanandroid/core/page/PageState;", "Lcom/gzq/wanandroid/model/HomeListItem;", "_selectTabIndex", "", "allData", "currentPage", "homeTab", "Landroidx/lifecycle/LiveData;", "getHomeTab", "()Landroidx/lifecycle/LiveData;", "listState", "getListState", "pageState", "getPageState", "selectTabIndex", "getSelectTabIndex", "afterRemoveUpdateListData", "", "newData", "fetchHomeList", "isRefresh", "", "tabName", "filterListDataByTabId", "updateSelectTabIndex", "index", "app_debug"})
public final class HomeMainViewModel extends com.gzq.wanandroid.core.base.BaseViewModel {
    private int currentPage = -1;
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _selectTabIndex = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.lang.Integer> selectTabIndex = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.gzq.wanandroid.model.HomeListItem>> allData = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> _homeTab = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> homeTab = null;
    private final androidx.lifecycle.MutableLiveData<com.gzq.wanandroid.core.page.PageState<java.util.List<com.gzq.wanandroid.model.HomeListItem>>> _pageState = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.gzq.wanandroid.core.page.PageState<java.util.List<com.gzq.wanandroid.model.HomeListItem>>> pageState = null;
    private final androidx.lifecycle.MutableLiveData<com.gzq.wanandroid.widget.RefreshLoadMoreState> _listState = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.gzq.wanandroid.widget.RefreshLoadMoreState> listState = null;
    
    public HomeMainViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Integer> getSelectTabIndex() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> getHomeTab() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.gzq.wanandroid.core.page.PageState<java.util.List<com.gzq.wanandroid.model.HomeListItem>>> getPageState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.gzq.wanandroid.widget.RefreshLoadMoreState> getListState() {
        return null;
    }
    
    /**
     * 获取首页的数据
     */
    public final void fetchHomeList(boolean isRefresh, @org.jetbrains.annotations.Nullable
    java.lang.String tabName) {
    }
    
    /**
     * 根据tabId筛选数据
     */
    public final void filterListDataByTabId(@org.jetbrains.annotations.NotNull
    java.lang.String tabName) {
    }
    
    public final void updateSelectTabIndex(int index) {
    }
    
    public final void afterRemoveUpdateListData(@org.jetbrains.annotations.NotNull
    java.util.List<com.gzq.wanandroid.model.HomeListItem> newData) {
    }
}