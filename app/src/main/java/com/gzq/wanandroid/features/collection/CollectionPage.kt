package com.gzq.wanandroid.features.collection

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.DismissDirection
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.gzq.wanandroid.R
import com.gzq.wanandroid.features.home.home.components.HomeListItemC
import com.gzq.wanandroid.model.Article
import com.gzq.wanandroid.router.Router
import com.gzq.wanandroid.router.isHomePage
import com.gzq.wanandroid.widget.MyTopAppBar
import com.gzq.wanandroid.widget.RefreshLoadMoreLazyColum
import com.gzq.wanandroid.widget.RefreshLoadMoreState

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.collectionPage(
    navController: NavHostController,
    showBottomNavigationBar: (Boolean) -> Unit
) {
    composable(Router.CollectionPage.route) {
        CollectionPage(launchToDetailPage = {
            navController.navigate(Router.DetailPage.createRoute(it.toJson()))
        }) {
            showBottomNavigationBar(navController.previousBackStackEntry!!.isHomePage())
            navController.popBackStack()
        }
    }
}

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterialApi::class,
    ExperimentalFoundationApi::class
)
@Composable
fun CollectionPage(
    viewModel: CollectionViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    launchToDetailPage: (Article) -> Unit,
    clickBack: () -> Unit
) {
    val refreshLoadMoreState by viewModel.listState.observeAsState(RefreshLoadMoreState.Idle)

    val listData by viewModel.listData.observeAsState(emptyList())

    Scaffold(topBar = {
        MyTopAppBar(title = stringResource(id = R.string.my_collection), clickBack = clickBack)
    }) { paddingValues ->
        RefreshLoadMoreLazyColum(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            state = refreshLoadMoreState,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            onRefreshCallBack = {
                viewModel.fetchMyCollection(true)
            },
            loadMoreCallBack = {
                viewModel.fetchMyCollection(false)
            },
        ) {
            /**
             * 支持从左到右滑动删除
             */
            itemsIndexed(
                items = listData,
                key = { _, item -> item.uid }
            ) { index, item ->

                // 侧滑删除所需State
                val dismissState = rememberDismissState()
                if (dismissState.isDismissed(DismissDirection.StartToEnd)) {
                    viewModel.afterRemoveUpdateListData(item)
                }
                SwipeToDismiss(
                    state = dismissState,
                    //animateItemPlacement() 此修饰符便添加了动画
                    Modifier.animateItemPlacement(),
                    // 允许滑动删除的方向
                    directions = setOf(DismissDirection.StartToEnd),
                    // "背景 "，即原来显示的内容被划走一部分时显示什么
                    background = {},
                    //下面这个参数为触发滑动删除的移动阈值
                    dismissThresholds = { direction ->
                        FractionalThreshold(if (direction == DismissDirection.StartToEnd) 0.25f else 0.5f)
                    },
                ) {
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
                        launchToDetailPage.invoke(item)
                    }
                }
            }
        }
    }
}