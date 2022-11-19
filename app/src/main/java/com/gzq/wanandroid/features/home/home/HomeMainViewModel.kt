package com.gzq.wanandroid.features.home.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gzq.wanandroid.core.base.BaseViewModel
import com.gzq.wanandroid.core.exception.Failure
import com.gzq.wanandroid.core.page.PageState
import com.gzq.wanandroid.model.Article
import com.gzq.wanandroid.repository.MyRepository
import com.gzq.wanandroid.widget.RefreshLoadMoreState
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeMainViewModel : BaseViewModel() {
    private var currentPage: Int = -1

    private val _selectTabIndex = MutableLiveData(0)
    val selectTabIndex: LiveData<Int> = _selectTabIndex


    private val allData = MutableLiveData<List<Article>>(emptyList())

    private val _homeTab = MutableLiveData<List<String>>(emptyList())
    val homeTab: LiveData<List<String>> = _homeTab

    private val _pageState = MutableLiveData<PageState<List<Article>>>(PageState.Loading)
    val pageState: LiveData<PageState<List<Article>>> = _pageState

    private val _listState = MutableLiveData<RefreshLoadMoreState>(RefreshLoadMoreState.Idle)
    val listState: LiveData<RefreshLoadMoreState> = _listState

    init {
        fetchHomeList(isRefresh = true, tabName = null)
    }

    /**
     * 获取首页的数据
     */
    fun fetchHomeList(isRefresh: Boolean, tabName: String?) {
        if (isRefresh) {
            currentPage = -1
            _listState.value = RefreshLoadMoreState.Refresh
        }
        viewModelScope.launch {
            Timber.tag("技术周报").d("page:$currentPage")
            MyRepository.fetchHomeList(++currentPage)
                .onSuccess { data ->
                    if (data == null) {
                        _error.value = Failure.EmptyData
                        return@onSuccess
                    }
                    currentPage = data.curPage - 1

                    Timber.tag("技术周报").d("之前：${allData.value!!.size}")
                    //将数据赋值，后面遍历会使用
                    if (isRefresh) {
                        allData.value = data.datas
                    } else {
                        val tempAllData = allData.value!!.toMutableList()
                        tempAllData.addAll(data.datas)
                        allData.value = tempAllData
                    }

                    //缓存Tab
                    val tempList = _homeTab.value!!.toMutableList()
                    tempList.addAll(data.datas.map {
                        it.superChapterName
                    })
                    //去重
                    _homeTab.value = tempList.toSet().toList()

                    //更新刷新组件的状态
                    _listState.value =
                        if (data.over) RefreshLoadMoreState.NoMore else RefreshLoadMoreState.HasMore

                    filterListDataByTabId(tabName ?: _homeTab.value!![_selectTabIndex.value!!])
                }
                .onFailure {
                    _error.value = it
                    _listState.value = RefreshLoadMoreState.LoadMoreError(it)
                }
        }
    }

    /**
     * 根据tabId筛选数据
     */
    fun filterListDataByTabId(tabName: String) {

        val pageStateSuccess = _pageState.value as? PageState.Success

        val oldSize = pageStateSuccess?.let { it.data?.size ?: 0 }

        val newData = allData.value!!.filter { it.superChapterName == tabName }

        if (oldSize == newData.size) {
            _listState.value =
                RefreshLoadMoreState.LoadMoreError(error = Throwable("当前分页无更多，点击加载下一页"))
        }

        _pageState.value = PageState.Success(newData)
    }

    fun updateSelectTabIndex(index: Int) {
        _selectTabIndex.value = index
    }

    fun afterRemoveUpdateListData(newData: List<Article>) {
        _pageState.value = PageState.Success(newData)
    }
}