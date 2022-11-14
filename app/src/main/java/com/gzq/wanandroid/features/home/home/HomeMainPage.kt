package com.gzq.wanandroid.features.home.home

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.gzq.wanandroid.BuildConfig
import com.gzq.wanandroid.core.page.PageState
import com.gzq.wanandroid.core.preview.ThemePreviews
import com.gzq.wanandroid.core.quality.LogCompositions
import com.gzq.wanandroid.core.quality.recomposeHighlighter
import com.gzq.wanandroid.exit_app.MyBackHandler
import com.gzq.wanandroid.features.main.LocalLoginState
import com.gzq.wanandroid.features.home.home.components.HomeListItemC
import com.gzq.wanandroid.features.main.LocalSnackbarHostState
import com.gzq.wanandroid.router.Router
import com.gzq.wanandroid.widget.PageHolder
import com.gzq.wanandroid.widget.RefreshLoadMoreLazyColum
import com.gzq.wanandroid.widget.RefreshLoadMoreState
import kotlinx.coroutines.launch
import timber.log.Timber


fun NavGraphBuilder.homeMainPage(
    navController: NavHostController,
    showBottomNavigationBar: (Boolean) -> Unit
) {
    composable(Router.HomePage.route) {
        HomeMainPage { url ->
            showBottomNavigationBar(false)
            navController.navigate(Router.DetailPage.createRoute(url))
        }
    }
}

@ThemePreviews
@Composable
fun HomeMainPage(
    modifier: Modifier = Modifier,
    viewModel: HomeMainViewModel = viewModel(),
    launchToDetailPage: ((String) -> Unit)? = null
) {
    val pageState by viewModel.pageState.observeAsState(PageState.Loading)

    val tabs by viewModel.homeTab.observeAsState(emptyList())

    val selectTab by viewModel.selectTabIndex.observeAsState(0)

    val refreshLoadMoreState by viewModel.listState.observeAsState(RefreshLoadMoreState.Idle)

    MyBackHandler()

    PageHolder(
        pageState,
        modifier
    ) { data ->
        val isDark = isSystemInDarkTheme()
        Column {
            Surface(elevation = 4.dp) {
                ScrollableTabRow(
                    selectedTabIndex = selectTab,
                    backgroundColor =
                    if (isDark) MaterialTheme.colorScheme.surface
                    else MaterialTheme.colorScheme.primary,
                    edgePadding = 0.dp,
                    indicator = {
                        TabRowDefaults.Indicator(
                            Modifier
                                .tabIndicatorOffset(it[selectTab]),
                            color = MaterialTheme.colorScheme.tertiaryContainer
                        )
                    }
                ) {
                    tabs.forEachIndexed { index, s ->
                        Tab(
                            selected = index == selectTab,
                            selectedContentColor = if (isDark) MaterialTheme.colorScheme.onSurface
                            else MaterialTheme.colorScheme.onPrimary,
                            onClick = {
                                //重复点击同一个tab，不做任何操作
                                if (selectTab == index) {
                                    return@Tab
                                }
                                viewModel.filterListDataByTabId(tabs[index])
                                viewModel.updateSelectTabIndex(index)
                            }, text = {
                                Text(text = s)
                            })
                    }
                }
            }

            RefreshLoadMoreLazyColum(
                modifier = Modifier.fillMaxSize(),
                state = refreshLoadMoreState,
                verticalArrangement = Arrangement.spacedBy(16.dp),
                onRefreshCallBack = {
                    viewModel.fetchHomeList(isRefresh = true, tabName = tabs[selectTab])
                },
                loadMoreCallBack = {
                    viewModel.fetchHomeList(
                        isRefresh = false,
                        tabName = tabs[selectTab]
                    )
                },
            ) {
                /**
                 * 支持从左到右滑动删除
                 */
                itemsIndexed(
                    items = data ?: emptyList(),
//                    key = { _, item -> item.id }
                ) { index, item ->

//                    // 侧滑删除所需State
//                    val dismissState = rememberDismissState()
//                    if (dismissState.isDismissed(DismissDirection.StartToEnd)) {
//                        viewModel.afterRemoveUpdateListData(
//                            data!!.toMutableList().also { it.remove(item) })
//                    }
//                    SwipeToDismiss(
//                        state = dismissState,
//                        //animateItemPlacement() 此修饰符便添加了动画
//                        Modifier.animateItemPlacement(),
//                        // 允许滑动删除的方向
//                        directions = setOf(DismissDirection.StartToEnd),
//                        // "背景 "，即原来显示的内容被划走一部分时显示什么
//                        background = {},
//                        //下面这个参数为触发滑动删除的移动阈值
//                        dismissThresholds = { direction ->
//                            FractionalThreshold(if (direction == DismissDirection.StartToEnd) 0.25f else 0.5f)
//                        },
//                    ) {
                    HomeListItemC(
                        modifier = Modifier
                            .padding(
                                top = if (index == 0) 12.dp else 0.dp,
                                start = 16.dp,
                                end = 16.dp
                            )
                            .fillMaxWidth(),
                        data = item
                    ) {
                        launchToDetailPage?.invoke(item.link)
                    }
//                    }
                }
            }
        }
    }
}

