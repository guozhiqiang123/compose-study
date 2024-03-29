package com.gzq.wanandroid.features.home.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.gzq.wanandroid.core.page.PageState
import com.gzq.wanandroid.core.preview.ThemePreviews
import com.gzq.wanandroid.exit_app.MyBackHandler
import com.gzq.wanandroid.features.home.home.components.HomeListItemC
import com.gzq.wanandroid.model.Article
import com.gzq.wanandroid.router.Router
import com.gzq.wanandroid.ui.common.ArticleListItemC
import com.gzq.wanandroid.widget.PageHolder
import com.gzq.wanandroid.widget.RefreshLoadMoreLazyColum
import com.gzq.wanandroid.widget.RefreshLoadMoreState


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.homeMainPage(
    navController: NavHostController,
    showBottomNavigationBar: (Boolean) -> Unit
) {
    composable(Router.HomePage.route) {
        HomeMainPage { data ->
            showBottomNavigationBar(false)
            navController.navigate(Router.DetailPage.createRoute(data.toJson()))
        }
    }
}

@ThemePreviews
@Composable
fun HomeMainPage(
    modifier: Modifier = Modifier,
    viewModel: HomeMainViewModel = viewModel(),
    launchToDetailPage: ((Article) -> Unit)? = null
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
                verticalArrangement = Arrangement.spacedBy(12.dp),
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
                itemsIndexed(
                    items = data ?: emptyList(),
                ) { index, item ->
                    ArticleListItemC(
                        article = item,
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .clickable {
                                launchToDetailPage?.invoke(item)
                            }
                    )
                }
            }
        }
    }
}

