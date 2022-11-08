package com.gzq.wanandroid.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


enum class RefreshLoadMoreState {
    Idle, Refresh, HasMore, NoMore, LoadError, CurrNoMore
}

/**
 * 下拉刷新上拉加载控件
 * @param modifier Modifier
 * @param state RefreshLoadMoreState   控件状态，当设置为[RefreshLoadMoreState.Idle]时，则屏蔽加载更多
 * @param onRefreshCallBack Function0<Unit> 下拉刷新回调
 * @param loadMoreCallBack Function0<Unit>  加载更多回调
 * @param content [@kotlin.ExtensionFunctionType] Function1<LazyListScope, Unit>
 */
@Composable
fun RefreshLoadMoreLazyColum(
    modifier: Modifier = Modifier,
    state: RefreshLoadMoreState,
    listState: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    reverseLayout: Boolean = false,
    verticalArrangement: Arrangement.Vertical =
        if (!reverseLayout) Arrangement.Top else Arrangement.Bottom,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    flingBehavior: FlingBehavior = ScrollableDefaults.flingBehavior(),
    userScrollEnabled: Boolean = true,
    onRefreshCallBack: () -> Unit,
    loadMoreCallBack: () -> Unit,
    loadMore: @Composable () -> Unit = @Composable {
        Box(
            modifier = if (state != RefreshLoadMoreState.CurrNoMore) Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
            else Modifier
                .fillMaxWidth()
                .clickable {
                    loadMoreCallBack()
                }
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = when (state) {
                    RefreshLoadMoreState.HasMore -> "正在加载.."
                    RefreshLoadMoreState.NoMore -> "没有更多数据了.."
                    RefreshLoadMoreState.LoadError -> "网络出错，点击重试！"
                    RefreshLoadMoreState.CurrNoMore -> "当前分页无更多，点击加载下一页"
                    else -> ""
                },
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    },
    content: LazyListScope.() -> Unit
) {
    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = state == RefreshLoadMoreState.Refresh),
        onRefresh = { onRefreshCallBack() }
    ) {
        LazyColumn(
            modifier,
            state = listState,
            contentPadding = contentPadding,
            reverseLayout = reverseLayout,
            verticalArrangement = verticalArrangement,
            horizontalAlignment = horizontalAlignment,
            flingBehavior = flingBehavior,
            userScrollEnabled = userScrollEnabled
        ) {
            content()
            if (state == RefreshLoadMoreState.Idle) return@LazyColumn
            item {
                loadMore()
                if (state == RefreshLoadMoreState.HasMore) {
                    loadMoreCallBack()
                }
            }
        }
    }
}