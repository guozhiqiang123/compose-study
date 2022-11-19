package com.gzq.wanandroid.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


sealed class RefreshLoadMoreState {
    /**
     * 初始状态
     */
    object Idle : RefreshLoadMoreState()

    /**
     * 正在刷新
     */
    object Refresh : RefreshLoadMoreState()

    /**
     * 初次加载即出现错误
     */
    data class Error(
        val error: Throwable? = null,
        val btnLabel: String? = "点击重试"
    ) : RefreshLoadMoreState()

    /**
     * 空数据
     */
    object NoData : RefreshLoadMoreState()

    /**
     * 标记有更多数据
     */
    object HasMore : RefreshLoadMoreState()

    /**
     * 标记没有更多数据
     */

    object NoMore : RefreshLoadMoreState()

    /**
     * 加载更多出现错误
     */
    data class LoadMoreError(
        val error: Throwable? = null,
        val customClick: Boolean = false
    ) : RefreshLoadMoreState()

    /**
     * 当前分页没有更多
     */
    object CurrNoMore : RefreshLoadMoreState()
}

/**
 * 下拉刷新上拉加载控件
 * @param modifier Modifier
 * @param state RefreshLoadMoreState   控件状态，当设置为[RefreshLoadMoreState.Idle]时，则屏蔽加载更多
 * @param listState LazyColumn的状态管理
 * @param contentPadding 控制整个列表数据的内边距
 * @param reverseLayout 是否反布局
 * @param verticalArrangement 垂直方向布局
 * @param horizontalAlignment 水平方向布局
 * @param flingBehavior 滑翔Behavior
 * @param userScrollEnabled 用户是否可滚 默认true
 * @param onRefreshCallBack Function0<Unit> 下拉刷新回调
 * @param loadMoreCallBack Function0<Unit>  加载更多回调
 * @param customClickLoadMoreCallBack 自定义点击列表尾布局事件，默认回调loadMoreCallBack
 * @param loadMoreContent 自定义加载更多的视图 默认纯文本
 * @param errorRetryCallBack 出错了，点击重试按钮回调。默认为重试，也可以自定义，或者[RefreshLoadMoreState.Error.btnLabel]传null，可以隐藏按钮
 * @param errorContent 自定义出错布局，默认文本+重试按钮。注意：自定义该视图，[errorRetryCallBack]不再生效。
 * @param noDataContent 自定义空数据布局，默认只有一个文本。
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
    customClickLoadMoreCallBack: (Throwable?) -> Unit = { loadMoreCallBack() },
    loadMoreContent: @Composable () -> Unit = @Composable {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .then(if (state is RefreshLoadMoreState.LoadMoreError && state.customClick)
                    Modifier.clickable { customClickLoadMoreCallBack(state.error) } else Modifier)
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = when (state) {
                    RefreshLoadMoreState.HasMore -> "正在加载.."
                    RefreshLoadMoreState.NoMore -> "没有更多数据了.."
                    is RefreshLoadMoreState.LoadMoreError -> state.error?.message ?: "哎呀，出错了！"
                    else -> ""
                },
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    },
    errorRetryCallBack: ((Throwable?) -> Unit)? = null,
    errorContent: @Composable (RefreshLoadMoreState.Error?) -> Unit = @Composable {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = it?.error?.message ?: "哎呀，出错了！")

            if (it?.btnLabel != null) {
                Spacer(modifier = Modifier.height(12.dp))
                Button(onClick = { errorRetryCallBack?.invoke(it.error) }) {
                    Text(text = it.btnLabel)
                }
            }
        }
    },
    noDataContent: @Composable () -> Unit = @Composable {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "没有数据")
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
            if (state is RefreshLoadMoreState.Error) {
                item { errorContent(state) }
            } else if (state == RefreshLoadMoreState.NoData) {
                item { noDataContent() }
            } else {
                content()
                if (state == RefreshLoadMoreState.Idle) return@LazyColumn
                item {
                    loadMoreContent()
                    if (state == RefreshLoadMoreState.HasMore) {
                        loadMoreCallBack()
                    }
                }
            }
        }
    }
}